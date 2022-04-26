(defproject principles-systems-architecture "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [prismatic/schema "1.2.0"]]
  :source-paths ["src/clj"]
  :java-source-paths ["src/java"]
  :profiles {:dev {:source-paths ["dev/clj"]
                   :plugins [[jonase/eastwood "1.2.3"]
                             [lein-cljfmt "0.8.0"]
                             [lein-kibit "0.1.8"]]
                   :aliases {"lint" ^{:doc "Execute cljfmt check, eastwood and kibit."}
                             ["do" ["cljfmt" "check"] ["eastwood"] ["kibit"]]}}})
