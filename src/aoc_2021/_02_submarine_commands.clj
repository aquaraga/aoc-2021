(ns aoc-2021._02-submarine-commands
  (:require [clojure.string :as str]
            [aoc-2021.__data :refer :all]))

(defn command-val [x] (Integer/parseInt (last (str/split x #" "))))

(defn sum-where [prefix elems]
  (reduce + (map #(command-val %) (filter #(str/starts-with? % prefix) elems))))

(defn aim-hor-ver [elems]
  (reduce (fn [[aim hor ver] x]
            (let [val (command-val x)]
              (cond
                (str/starts-with? x "up") [(- aim val) hor ver]
                (str/starts-with? x "down") [(+ aim val) hor ver]
                (str/starts-with? x "forward") [aim (+ hor val) (+ ver (* aim val))]
                ))) [0 0 0] elems))

(defn -main [& _]
  (println (let [hor (sum-where "forward" commands)
                 up (sum-where "up" commands)
                 down (sum-where "down" commands)] (* hor (- down up))))
  (println (let [[_ hor ver] (aim-hor-ver commands)]
             (* hor ver))))