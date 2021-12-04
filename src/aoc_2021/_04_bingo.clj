(ns aoc-2021._04-bingo
  (:require [clojure.string :as str]
            [aoc-2021.__data :refer :all]))

(defn to-int-vec [str-vec]
  (vec (map #(Integer/parseInt (str/trim %)) str-vec)))

(defn get-bingo-boards [elems]
  (->> elems
       (filter #(not-empty %))
       (map #(to-int-vec (str/split (str/trim %) #"\s+")))
       (partition 5)
       (map #(vec (flatten %)))
       (vec)))

(defn col-partition [board]
  (map (fn [gp] (map (fn [x] (last x)) gp))
       (vals (group-by #(first %) (map vector (cycle [1 2 3 4 5]) board)))))

(defn has-won [board]
  (let [winner [-1 -1 -1 -1 -1]]
    (or (some #(= winner %) (partition 5 board))
        (some #(= winner %) (col-partition board)))))

(defn play [boards input]
  (map #(let [index (.indexOf % input)]
          (if (= -1 index) % (assoc % index -1))) boards))

(defn score [board input]
  (* input (reduce + (filter #(not= -1 %) board))))

(defn winning-board-score [boards bing-inputs]
  (loop [acc boards last-played -1 inputs bing-inputs]
    (let [winning-boards (filter has-won acc) current-input (first inputs)]
      (if (seq winning-boards)
        (score (first winning-boards) last-played)
        (recur (play acc current-input) current-input (rest inputs))))))

(defn -main [& _]
  (println (winning-board-score (get-bingo-boards bingo-boards) bingo-inputs)))