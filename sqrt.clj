(ns clojure.examples.sqrt
  (:gen-class))
(def tolerance 0.00001)
(defn abs [n]
  (max n (- n)))
(defn fixed-point [f initial-guess]
  (let [close-enough? #(< (abs (- %1 %2)) tolerance)]
    (loop [guess initial-guess]
      (let [next-guess (f guess)]
        (if (close-enough? guess next-guess)
          next-guess
          (recur next-guess))))))
(defn average-damp [f]
  (letfn [(avg [x y] (/ (+ x y) 2))]
    (fn [x] (avg x (f x)))))
(defn sqrt [x]
  (fixed-point (average-damp #(/ x %)) 1.0))
(defn sqrt-trace [x, n]
  (take n (iterate (average-damp #(/ x %)) 1.0)))
(println (sqrt 2.0))
(println (sqrt-trace 2.0 5))
