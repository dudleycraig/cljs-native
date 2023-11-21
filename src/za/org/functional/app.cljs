(ns za.org.functional.app
  (:require ["react" :as r]
            ["react-native" :as rn :refer [View Text StyleSheet Button]]
            ["@react-navigation/native" :as rnn :refer [NavigationContainer]]
            ["@react-navigation/native-stack" :as rnns :refer [createNativeStackNavigator]]
            ["@react-navigation/bottom-tabs" :as rnbt :refer [createBottomTabNavigator]]

            ["tailwind-rn" :refer [TailwindProvider] :as tailwind]
 
            ["expo-status-bar" :refer [StatusBar]]
            [expo.root :refer [render-root]]

            [helix.core :as hc :refer [defnc fnc $ <>]]
            [helix.dom :as hd]
            [helix.hooks :as hh]
            [cljs.pprint :as pp :refer [pprint]]

            [za.org.functional.providers.app-provider :as app-provider :refer [AppProvider]]

            [za.org.functional.store.contracts]
            [za.org.functional.store.developer-roles]
            [za.org.functional.store.employers]
            [za.org.functional.store.icons]
            [za.org.functional.store.images]
            [za.org.functional.store.projects]
            [za.org.functional.store.technologies]
            
            [za.org.functional.screens.home :refer [Home]]
            [za.org.functional.screens.portfolio :refer [Portfolio]]
            [za.org.functional.screens.contact :refer [Contact]] 
            [za.org.functional.screens.resume :refer [Resume]]
           
            [za.org.functional.components.main-header :refer [MainHeader]]))

(def tailwind-json (js/require "../tailwind.json"))

(defonce Tab (createBottomTabNavigator))

(defnc Root []
  ($ TailwindProvider {:utilities tailwind-json}
    ($ AppProvider
      ($ NavigationContainer
        ($ Tab.Navigator
          {:id "FooterNavigator"
           :screenOptions (fn [js-params]
                            (let [navigation   (. js-params -navigation)
                                  route        (. js-params -route)]
                              #js {:tabBarLabelStyle #js {}
                                   :header (fn [props] ($ MainHeader {:navigation navigation :route route & props}))}))}
          ($ Tab.Screen {:name "resume" :options #js {:title "Résumé"}} Resume)
          ($ Tab.Screen {:name "home" :options #js {:title "Home"}} Home)
          ($ Tab.Screen {:name "portfolio" :options #js {:title "Portfolio"}} Portfolio)
          ($ Tab.Screen {:name "contact" :options #js {:title "Contact"}} Contact))))))

(defn start
  {:dev/after-load true}
  []
  (render-root ($ Root)))

(defn init [] (start))
