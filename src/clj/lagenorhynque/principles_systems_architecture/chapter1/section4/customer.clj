(ns lagenorhynque.principles-systems-architecture.chapter1.section4.customer
  (:require
   [schema.core :as s]))

(s/defrecord Customer
  [name :- s/Str])

(s/defn customer :- Customer
  [name :- s/Str]
  (->Customer name))
