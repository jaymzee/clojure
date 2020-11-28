(ns clojure.examples.macro
  (:gen-class))
(defmacro infix
  "Use this macro when you pine for the notation of your childhood"
  [[op1 op op2]]
  (list op op1 op2))
(println (str "1 + 2 = " (infix (1 + 2))))
(println (str "3 * 4 = " (infix (3 * 4))))
