(ns example.screens.contact
  (:require ["react" :as r]
            ["react-native" :as rn :refer [View Text StyleSheet Button]]
            ["tailwind-rn" :as tailwind]
 
            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]
            
            [example.providers.app-provider :as app-provider]))

(defnc Contact [{:keys [navigation route] :as props}]
  (let [tw (tailwind/useTailwind)
        app-provider (app-provider/use-context)
        page (. route -name)]
    ($ View {:style (tw "pb-12 bg-red-200")}
      ($ Text page))))
