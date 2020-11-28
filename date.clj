(ns clojure.examples.date
  (:import java.util.Date)
  (:gen-class))
(defn date []
  (let [now (Date.)]
    (println (.toString now))))
(date)
