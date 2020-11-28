(ns clojure.examples.rel
  (:require [clojure.set :as set])
  (:use [clojure.pprint :only (pprint)])
  (:gen-class))
(def animals #{{:name "betsy" :owner "brian" :kind "cow"}
               {:name "jake"  :owner "brian" :kind "horse"}
               {:name "josie" :owner "dawn"  :kind "cow"}})
(def personalities #{{:kind "cow" :personality "stoic"}
                     {:kind "horse" :personality "skittish"}})
(pprint (set/join animals personalities))
