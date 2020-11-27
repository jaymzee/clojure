(ns javalib.core
  (:import javalib.data.Person)
  (:import javalib.data.Func)
  (:gen-class))
(defn square [x]
  (* x x))
(defn ^Func as-function [f]
  (reify Func
    (apply [this arg]
      (f arg))))
(defn -main
  "instatiate a person and say hello"
  [& args]
  (.sayHello (Person.))
  (Person/process (as-function square) 3.14)
  (Person/process (as-function inc) 3.14))
