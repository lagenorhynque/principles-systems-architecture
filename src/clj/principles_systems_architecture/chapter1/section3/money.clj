(ns principles-systems-architecture.chapter1.section3.money
  (:require [schema.core :as s])
  (:import (principles_systems_architecture.chapter1.section3.quantity Quantity)))

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
