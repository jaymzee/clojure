(ns clojure.examples.set
  (:require [clojure.set :as set])
  (:gen-class))
(def a #{1 2 3})
(def b #{3 5 4})
(println (str "    A = " a))
(println (str "    B = " b))
(println (str "A ∪ B = " (set/union a b)))
(println (str "A \\ B = " (set/difference a b)))
(println (str "A ∩ B = " (set/intersection a b)))
