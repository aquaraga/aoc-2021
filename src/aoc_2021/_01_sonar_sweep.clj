(ns aoc-2021._01-sonar-sweep
  (:require [aoc-2021.__data :refer :all]))

(defn count-increases
  [x]
  (count (filter identity (map < (butlast x) (rest x)))))
(defn sliding-window-sums [x] (map + x (rest x) (rest (rest x))))
(defn -main [& _]
  (println (count-increases readings))
  (println (count-increases (sliding-window-sums readings))))