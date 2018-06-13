#include <iostream>
#include <stdio.h>
#include <cstdlib>
#include <stdlib.h>
#include <signal.h>
#include <unistd.h>
#include <sys/wait.h>

using namespace std;

typedef void(*handler)(int);
void doFork(int);

void registerHandler(int, handler);
void hParentSignal(int);
void hChildSignalINT(int);
void hChildDodawanie(int);
void hChildMnozenie(int);

bool wait2 = true;

pid_t childPid;
pid_t parentPid;
pid_t cPid;
int PARAMETR;
int ITERATOR = 0;

int main(int argc, char** argv) {

	for (int i = 1; i < argc; i++) {		// od 1, zeby nie brak pod uwagi nazwy
		cout << "argv[" << i << "] = " << argv[i] << endl;
	}

	if (argc < 2) {
		cerr << "Podaj liczbe jako PIERWSZY argument!" << endl;
		exit(-1);
	}
	if (argc > 2) {
		cout << "Maksymalnie 1 argument!" << endl;
		exit(-1);
	}
	else {
		PARAMETR = atoi(argv[1]);

		parentPid = getpid();
		childPid = fork();

		if (childPid < 0) {
			cout << "Fork failed";
		}
		if (childPid > 0) {		// Co ma zrobic rodzic?
			cout << "Parent PID = " << getpid() << endl;

			registerHandler(SIGINT, &hParentSignal);
			registerHandler(SIGUSR2, &hParentSignal);
			kill(parentPid, SIGUSR2);

			int status = 0;
			while (waitpid(childPid, &status, 0) == -1);

			cout << "(parent) Wylaczam program." << endl;
		}
		if (childPid == 0) {		// Co ma zrobic dziecko?
			cout << "Child PID = " << getpid() << endl;

			registerHandler(SIGINT, &hChildSignalINT);
			registerHandler(SIGUSR2, &hChildDodawanie);

			while (wait2) {
				pause();
			}
		}
	}

	return 0;
}

void registerHandler(int signal, handler handle) {
	sigset_t iset;
	struct sigaction act;

	sigemptyset(&iset);

	act.sa_handler = handle;
	act.sa_mask = iset;
	act.sa_flags = 0;

	sigaction(signal, &act, NULL);
}

void hParentSignal(int signal) {
	string sygnal;
	if (signal == 2) sygnal = "INT";
	if (signal == 12) sygnal = "USR2";

	cout << "(parent) Otrzymano sygnal " << sygnal << endl;
	
	if (signal == 2) kill(childPid, signal);
}

void hChildDodawanie(int signal) {
	cout << "(child) Otrzymano sygnal USR2." << endl;
	if (ITERATOR < PARAMETR) {
		cout << "--------- ITERATOR = " << ITERATOR + 1 << ", PARAMETR = " << PARAMETR << endl;
		cout << "Sumuje... " << endl;
		ITERATOR++;
		cout << ITERATOR << "+" << ITERATOR << "=" << ITERATOR + ITERATOR << endl;
		cout << "----------------------------------------------" << endl;
		registerHandler(SIGUSR2, &hChildMnozenie);
	}
	else {
		wait2 = false;
	}
}

void hChildMnozenie(int signal) {
	cout << "(child) Otrzymano sygnal USR2." << endl;
	if (ITERATOR < PARAMETR) {
		cout << "--------- ITERATOR = " << ITERATOR + 1 << ", PARAMETR = " << PARAMETR << endl;
		cout << "Mnoze... " << endl;
		ITERATOR++;
		cout << ITERATOR << "*" << ITERATOR << "=" << ITERATOR * ITERATOR << endl;
		cout << "----------------------------------------------" << endl;
		registerHandler(SIGUSR2, &hChildDodawanie);
	}
	else {
		wait2 = false;
	}
}

void hChildSignalINT(int signal){
	cout << "(child) Otrzymano sygnal INT. Wylaczam program." << endl;
	wait2 = false;
}