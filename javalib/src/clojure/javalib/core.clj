(ns javalib.core
  (:import javalib.data.Person)
  (:gen-class))
(defn square [x]
  (* x x))
(defn square-function []
  (reify javalib.data.Func
    (apply [this arg]
      (square arg))))
(defn -main
  "instatiate a person and say hello"
  [& args]
  (.sayHello (Person.))
  (Person/process (square-function) 3.14))
