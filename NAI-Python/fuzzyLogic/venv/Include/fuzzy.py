# fuzzylogic
# Autorzy: Filip Krzysztofik, Sebastian Browarczyk

import numpy as np
import skfuzzy as fuzz
from skfuzzy import control as ctrl
import pylab

weight = ctrl.Antecedent(np.arange(500, 3500, 1), 'weight')
driving_style = ctrl.Antecedent(np.arange(0, 2, 1), 'driving_style')
type_of_tires = ctrl.Antecedent(np.arange(0, 3, 1), 'type_of_tires')
pressure = ctrl.Consequent(np.arange(1.7, 3.0, 0.1), 'pressure')


weight['light'] = fuzz.trimf(weight.universe, [400, 1200, 1500])
weight['medium'] = fuzz.trimf(weight.universe, [1300, 1800, 2400])
weight['heavy'] = fuzz.trimf(weight.universe, [2100, 2800, 3500])

type_of_tires['winter'] = fuzz.trimf(type_of_tires.universe, [0, 0, 0])
type_of_tires['summer'] = fuzz.trimf(type_of_tires.universe, [1, 1, 1])
type_of_tires['all-season'] = fuzz.trimf(type_of_tires.universe, [2, 2, 2])

driving_style['calm'] = fuzz.trimf(driving_style.universe, [0, 0, 0])
driving_style['aggressive'] = fuzz.trimf(driving_style.universe, [1, 1, 1])

pressure['low'] = fuzz.trimf(pressure.universe, [1.7, 2.0, 2.2])
pressure['average'] = fuzz.trimf(pressure.universe, [2.0,2.2,2.4])
pressure['high'] = fuzz.trimf(pressure.universe, [2.2,2.7,3.0])



rule1 = ctrl.Rule(weight['light'] & driving_style['calm'] & type_of_tires['summer'], pressure['low'])
rule2 = ctrl.Rule(weight['light'] & driving_style['calm'] & type_of_tires['winter'], pressure['low'])
rule3 = ctrl.Rule(weight['light'] & driving_style['calm'] & type_of_tires['all-season'], pressure['low'])
rule4 = ctrl.Rule(weight['light'] & driving_style['aggressive'] & type_of_tires['summer'], pressure['low'])
rule5 = ctrl.Rule(weight['light'] & driving_style['aggressive'] & type_of_tires['winter'], pressure['low'])
rule6 = ctrl.Rule(weight['light'] & driving_style['aggressive'] & type_of_tires['all-season'], pressure['low'])

rule7 = ctrl.Rule(weight['medium'] & driving_style['calm'] & type_of_tires['summer'], pressure['average'])
rule8 = ctrl.Rule(weight['medium'] & driving_style['calm'] & type_of_tires['winter'], pressure['average'])
rule9 = ctrl.Rule(weight['medium'] & driving_style['calm'] & type_of_tires['all-season'], pressure['average'])
rule10 = ctrl.Rule(weight['medium'] & driving_style['aggressive'] & type_of_tires['summer'], pressure['average'])
rule11 = ctrl.Rule(weight['medium'] & driving_style['aggressive'] & type_of_tires['winter'], pressure['average'])
rule12 = ctrl.Rule(weight['medium'] & driving_style['aggressive'] & type_of_tires['all-season'], pressure['average'])

rule13 = ctrl.Rule(weight['heavy'] & driving_style['calm'] & type_of_tires['winter'], pressure['high'])
rule14 = ctrl.Rule(weight['heavy'] & driving_style['calm'] & type_of_tires['summer'], pressure['high'])
rule15 = ctrl.Rule(weight['heavy'] & driving_style['calm'] & type_of_tires['all-season'], pressure['high'])
rule16 = ctrl.Rule(weight['heavy'] & driving_style['aggressive'] & type_of_tires['winter'], pressure['high'])
rule17 = ctrl.Rule(weight['heavy'] & driving_style['aggressive'] & type_of_tires['summer'], pressure['high'])
rule18 = ctrl.Rule(weight['heavy'] & driving_style['aggressive'] & type_of_tires['all-season'], pressure['high'])


rules = [ rule1,
          rule2,
          rule3,
          rule4,
          rule5,
          rule6,
          rule7,
          rule8,
          rule9,
          rule10,
          rule11,
          rule12,
          rule13,
          rule14,
          rule15,
          rule16,
          rule17,
          rule18
          ]


pressureMake_ctrl = ctrl.ControlSystem(rules)
pressureMake = ctrl.ControlSystemSimulation(pressureMake_ctrl)

pressureMake.input['weight'] = 1800
pressureMake.input['driving_style'] = 0
pressureMake.input['type_of_tires'] = 0


pressureMake.compute()

weight.view(sim = pressureMake)
type_of_tires.view(sim = pressureMake)
driving_style.view(sim = pressureMake)
pressure.view(sim = pressureMake)
pylab.show()
