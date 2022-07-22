(ns ga-service.context)

(defn generateEncoding
  "Generates a random encoding according to the encoding length."
  [encodingLength]
  (loop [count encodingLength
         encoding []]
    (if (zero? count)
      encoding
      (let [value (rand-int 1)]
        (recur (dec count) (conj encoding value))))))

(defn generateMember
  "Generates a population member according to the encoding length with a default fitness."
  [encodingLength]
  {:encoding (generateEncoding encodingLength)
   :fitness (Double/MAX_VALUE)})

(defn generatePopulation
  "Generates the population of the Genetic Algorithm according to the given parameters"
  [populationCount encodingLength]
  (loop [count populationCount
         population []]
    (if (zero? count)
      population
      (let [member (generateMember encodingLength)]
        (recur (dec count) (conj population member))))))

(defn generateAlgorithmContext
  [populationCount encodingLength]
  (let [population (generatePopulation populationCount encodingLength)]
    {:population population
     :globalBestMember (first population)
     :averageFitness (Double/MAX_VALUE)
     :dataURI "TO_BE_IMPLEMENTED_LATER"
     :fitnessFunction "A_STRING"})) 