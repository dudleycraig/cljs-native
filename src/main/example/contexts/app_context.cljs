(ns example.contexts.app-context
  (:require ["react" :as r]
            
            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]))

(defonce AppContext (r/createContext {:property "value"}))
(defn use-context [] (hh/use-context AppContext))
