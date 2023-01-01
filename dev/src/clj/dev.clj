(ns dev
  (:require
   [clojure.java.io :as io]
   [clojure.repl :refer :all]
   #_[clojure.spec.alpha :as s]
   [clojure.tools.namespace.repl :refer [refresh]]
   [expound.alpha :as expound]
   [orchestra.spec.test :as stest]
   [schema.core :as s]))

(clojure.tools.namespace.repl/set-refresh-dirs "dev/src/clj" "src/clj" "test/clj")

#_(set! s/*explain-out* (expound/custom-printer {:theme :figwheel-theme}))

(s/set-fn-validation! true)
