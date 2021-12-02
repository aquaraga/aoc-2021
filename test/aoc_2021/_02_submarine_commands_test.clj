(ns aoc-2021._02-submarine-commands-test
  (:require [clojure.test :refer :all]
            [aoc-2021._02-submarine-commands :refer :all]))

(deftest sum-where-test
  (testing "should sum up numbers from strings where there is a prefix match"
    (is (= 12 (sum-where "pref" ["prefi 2" "pref 7" "pre 2" "p 5" "prefix 1" "prefix 2"])))))

(deftest aim-hor-ver-test
  (testing "should get horizontal and vertical positions by considering aim"
    (is (= [16 62] (let [[_ hor ver] (aim-hor-ver ["forward 9",
                                                   "down 3",
                                                   "down 8",
                                                   "forward 2",
                                                   "up 3",
                                                   "forward 5",
                                                   "up 8"])] [hor ver])))))
