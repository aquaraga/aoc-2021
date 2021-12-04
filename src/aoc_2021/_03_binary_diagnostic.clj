(ns aoc-2021._03-binary-diagnostic
  (:require [clojure.string :as str]
            [aoc-2021.__data :refer :all]))

(defn count-where [elem elems] (count (filter #(= % elem) elems)))
(def ones (partial count-where \1))
(def zeroes (partial count-where \0))

(defn slice-seq [elems]
  (letfn [(slice [elems i] (str/join "" (map #(nth % i) elems)))]
    (map #(slice elems %) (range (count (nth elems 0))))))

(defn gamma [elems] (str/join "" (map #(if (> (ones %) (zeroes %)) \1 \0) (slice-seq elems))))
(defn epsilon [elems] (str/join "" (map #(if (< (ones %) (zeroes %)) \1 \0) (slice-seq elems))))

(defn -main [& _]
  (println "Power consumption "
           (* (Integer/parseInt (gamma report) 2)
              (Integer/parseInt (epsilon report) 2))))