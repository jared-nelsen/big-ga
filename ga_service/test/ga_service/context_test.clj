(ns ga-service.context_test
  (:require [clojure.test :refer :all]
            [ga-service.context :as context]))

(deftest generateAlgorithmContextTest
  (testing "Tests that an algorithm context is actually created."
    (let [populationCount 11
          encodingLength 99
          context (ga-service.context/generateAlgorithmContext populationCount encodingLength)]
      (is (not (empty? context)))
      (is (= populationCount (count (:population context))))
      (is (= encodingLength (count (:encoding (first (:population context)))))))))