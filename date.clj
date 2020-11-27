(ns clojure.examples.date
  (:gen-class)
  (:import java.util.Date))
(defn date []
  (let [now (Date.)]
    (println (.toString now))))
(date)
