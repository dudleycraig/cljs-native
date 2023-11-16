(ns example.screens.resume
  (:require ["react" :as r]
            ["react-native" :as rn :refer [View Text StyleSheet Button]]
            ["tailwind-rn" :as tailwind]
 
            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]
            
            [example.contexts.app-context :as app-context]
            [example.providers.app-provider :refer [AppProvider]]))

(defnc Resume [{:keys [navigation route] :as props}]
  (let [tw (tailwind/useTailwind)
        app-context (app-context/use-context)
        page (. route -name)]
    ($ View {:style (tw "pb-12 bg-red-100")}
      ($ Text page))))
