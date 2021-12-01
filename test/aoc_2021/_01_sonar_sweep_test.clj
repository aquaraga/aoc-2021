(ns aoc-2021._01-sonar-sweep-test
  (:require [clojure.test :refer :all]
            [aoc-2021._01-sonar-sweep :refer :all]))

(deftest a-test
  (testing "should count increases in a list"
    (is (= 3 (count-increases [1 2 3 2 2 1 4 3]))))
  (testing "should count sums of three sliding windows"
    (is (= '(6 7 7 5 7 8) (sliding-window-sums [1 2 3 2 2 1 4 3])))))
