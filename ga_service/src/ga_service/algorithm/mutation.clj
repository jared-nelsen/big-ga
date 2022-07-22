(ns ga-service.algorithm.mutation)

(defn flipRandomBit
  [v]
  (let [randomBitIndex (rand-int (count v))
        bit (nth v randomBitIndex)
        flippedBit (if (= 0 bit) 1 0)
        before (take randomBitIndex v)
        after (nthrest v (inc randomBitIndex))]
    (vec (concat (conj before flippedBit) after))))
;; => #'ga-service.algorithm.mutation/flipRandomBit


(defn mutateMember
  "Mutates the given population member."
  [member]
  (let [encoding (:encoding member)
        mutatedEncoding ()]))

(defn mutatePopulation
  "Mutates the given population."
  [population]
  (loop [population population
         mutatedPopulation []]
    (if (empty? population)
      mutatedPopulation
      (let [member (first population)
            mutatedMember (mutateMember member)]
        (recur (rest population) (conj mutatedPopulation mutatedMember))))))

(defn mutate
  "Performs the mutation operation of the Genetic Algorithm"
  [context]
  (let [population (:population context)
        mutatedPopulation (mutatePopulation population)]
    (assoc context :population mutatedPopulation)))