(ns aoc-2021._05-vents-test
  (:require [clojure.test :refer :all]
            [aoc-2021._05-vents :refer :all]))

(def small-grid (vec (take 10 (repeatedly #(vec (repeat 10 0))))))

(def lines ["0,9 -> 5,9"
            "8,0 -> 0,8"
            "9,4 -> 3,4"
            "2,2 -> 2,1"
            "7,0 -> 7,4"
            "6,4 -> 2,0"
            "0,9 -> 2,9"
            "3,4 -> 1,4"
            "0,0 -> 8,8"
            "5,5 -> 8,2"])

(deftest count-intersections-test
  (testing "should count intersections of lines"
    (is (= 5 (count-intersections (plot-lines-on small-grid lines))))))
