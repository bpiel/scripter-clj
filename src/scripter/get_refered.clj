(ns scripter.get-refered
  (require [clojure.java.shell]
           [clojure.pprint]))


(def sh clojure.java.shell/sh)
(def p println)
(def ppr clojure.pprint/pprint)

(defn sh-out
  [& args]
  (->> args
       (map str)
       (apply sh)
       :out))

(defmacro s
  [& body]
  (let [body' (map #(if (list? %) % (str %))
                   body)]
    `(sh-out ~@body')))
