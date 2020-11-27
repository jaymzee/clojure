(ns javalib.core
  (:import javalib.data.Person)
  (:gen-class))

(defn -main
  "instatiate a person and say hello"
  [& args]
  (.sayHello (Person.)))
