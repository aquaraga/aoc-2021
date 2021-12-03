(ns aoc-2021._03-binary-diagnostic
  (:require [clojure.string :as str] [aoc-2021.__data :refer :all]))

(defn elem-by-freq [elems comparator-fn]
  ((comp first first)(sort-by val comparator-fn (frequencies elems))))
(defn most-common-elem [elems] (elem-by-freq elems >))
(defn least-common-elem [elems] (elem-by-freq elems <))

(defn slice-seq [elems]
  (letfn [(slice [elems i] (str/join "" (map #(nth % i) elems)))]
    (map #(slice elems %) (range (count (nth elems 0))))))

(defn gamma [elems] (str/join "" (map most-common-elem (slice-seq elems))))
(defn epsilon [elems] (str/join "" (map least-common-elem (slice-seq elems))))

(defn -main [& _]
  (println "Power consumption "
           (* (Integer/parseInt (gamma report) 2)
              (Integer/parseInt (epsilon report) 2))))