(ns aoc-2021._03-binary-diagnostic-test
  (:require [clojure.test :refer :all]
            [aoc-2021._03-binary-diagnostic :refer :all]))

(deftest gamma-test
  (testing "should calculate gamma value"
    (is (= "10110" (gamma ["00100",
                           "11110",
                           "10110",
                           "10111",
                           "10101",
                           "01111",
                           "00111",
                           "11100",
                           "10000",
                           "11001",
                           "00010",
                           "01010"])))))

(deftest epsilon-test
  (testing "should calculate epsilon value"
    (is (= "01001" (epsilon ["00100",
                             "11110",
                             "10110",
                             "10111",
                             "10101",
                             "01111",
                             "00111",
                             "11100",
                             "10000",
                             "11001",
                             "00010",
                             "01010"])))))

(deftest oxygen-test
  (testing "should calculate oxygen value"
    (is (= "10111" (oxygen-rating ["00100",
                             "11110",
                             "10110",
                             "10111",
                             "10101",
                             "01111",
                             "00111",
                             "11100",
                             "10000",
                             "11001",
                             "00010",
                             "01010"])))))

(deftest co2-test
  (testing "should calculate co2 rating"
    (is (= "01010" (co2-rating ["00100",
                                   "11110",
                                   "10110",
                                   "10111",
                                   "10101",
                                   "01111",
                                   "00111",
                                   "11100",
                                   "10000",
                                   "11001",
                                   "00010",
                                   "01010"])))))

