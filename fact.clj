(ns clojure.examples.factorial
  (:gen-class))
(defn factorial [n]
  (apply * (range n 1 -1)))
(println (factorial 5))
