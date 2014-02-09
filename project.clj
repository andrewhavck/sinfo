(defproject sinfo "0.1.0"
  :description "System Info"
  :url "https://github.com/andrewhavck/sinfo"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [local.repo/javasysmon "0.3.4"]]
  :profiles {:dev {:source-paths ["dev"]
                   :dependencies [[org.clojure/tools.namespace "0.2.4"]
                                  [org.clojure/java.classpath "0.2.2"]
                                  [lein-localrepo "0.5.3"]]}})
