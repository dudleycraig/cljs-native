(ns example.screens.resume
  (:require ["react" :as r]
            ["react-native" :as rn :refer [View Text StyleSheet Button]]
            ["tailwind-rn" :as tailwind]
 
            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]
            
            [example.providers.app-provider :as app-provider]

            [example.components.skills :refer [Skills]]
            [example.components.screen-container :refer [ScreenContainer]]))

(defnc Resume [{:keys [navigation route] :as props}]
  (let [tw (tailwind/useTailwind)
        app-provider (app-provider/use-context)
        page (. route -name)]
    ($ ScreenContainer
       ($ Skills))))
