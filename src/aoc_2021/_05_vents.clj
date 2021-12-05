(ns aoc-2021._05-vents
  (:require [aoc-2021.__data :refer :all]))

(def the-grid (vec (take 1000 (repeatedly #(vec (repeat 1000 0))))))

(defn inc-at [elems x y]
  (let [xth-elem (nth elems x)
        elem (nth xth-elem y)]
    (assoc elems x (assoc xth-elem y (inc elem)))))

(defn read-coords [coord-str]
  (let [[_ x1 y1 x2 y2] (re-matches #"(\d+),(\d+) -> (\d+),(\d+)" coord-str)]
    (map #(Integer/parseInt %) [x1 y1 x2 y2])))

(defn points-on [[x1 y1 x2 y2]]
  (cond
    (= x1 x2) (let [miny (min y1 y2) maxy (max y1 y2)] (map #(vector-of :int x1 %) (range miny (inc maxy))))
    (= y1 y2) (let [minx (min x1 x2) maxx (max x1 x2)] (map #(vector-of :int % y1) (range minx (inc maxx))))
    :else []
    )
  )

(defn plot-lines-on [grid coord-strs]
  (letfn [(plot-line-on [grid coords]
            (reduce (fn [acc [x, y]] (inc-at acc x y)) grid (points-on coords)))]
    (reduce #(plot-line-on %1 %2) grid (map #(read-coords %) coord-strs))))

(defn count-intersections [grid]
  (count (filter #(> % 1) (flatten grid))))

(defn -main [& _]
  (println (count-intersections (plot-lines-on the-grid lines))))