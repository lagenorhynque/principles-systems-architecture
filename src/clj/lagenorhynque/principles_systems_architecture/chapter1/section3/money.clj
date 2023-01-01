(ns lagenorhynque.principles-systems-architecture.chapter1.section3.money
  (:require
   [lagenorhynque.principles-systems-architecture.chapter1.section3.quantity]
   [schema.core :as s])
  (:import
   (lagenorhynque.principles_systems_architecture.chapter1.section3.quantity
    Quantity)))

(s/defrecord Money
  [value :- Long])

(s/defn money :- Money
  [value :- Long]
  (->Money value))

(s/defn minus :- Money
  [this :- Money
   other :- Money]
  (money (- (:value this) (:value other))))

(s/defn multiply :- Money
  [this :- Money
   quantity :- Quantity]
  (money (* (:value this) (:value quantity))))
