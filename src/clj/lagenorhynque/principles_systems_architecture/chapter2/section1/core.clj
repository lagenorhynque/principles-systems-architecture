(ns lagenorhynque.principles-systems-architecture.chapter2.section1.core
  (:require
   [lagenorhynque.principles-systems-architecture.chapter2.section1.state :as state]
   [schema.core :as s]))

;;; CHAPTER 2: 場合分けのロジックを整理する
;;; プログラムを複雑にする「場合分け」のコード

(defn execute1 []
  (println "(can-transit? :審査中 :承認済):"
           (state/can-transit? :審査中 :承認済)))

(defn -main [& args]
  (execute1))
