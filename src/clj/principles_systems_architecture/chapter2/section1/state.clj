(ns principles-systems-architecture.chapter2.section1.state
  (:require [schema.core :as s]))

(def State
  (s/enum :審査中
          :承認済
          :実施中
          :終了
          :差し戻し中
          :中断中))

(s/def allowed :- {State #{State}}
  {:審査中 #{:承認済 :差し戻し中}
   :差し戻し中 #{:審査中 :終了}
   :承認済 #{:実施中 :終了}
   :実施中 #{:中断中 :終了}
   :中断中 #{:実施中 :終了}})

(s/defn can-transit? :- s/Bool
  [from :- State
   to :- State]
  (contains? (get allowed from) to))
