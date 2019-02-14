//
//  RNRnmentoringprogramAsyncStorage.swift
//  RNRnmentoringprogramAsyncStorage
//
//  Created by Alex K on 2/13/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

import Foundation

@objc(RNRnmentoringprogramAsyncStorage)
class RNRnmentoringprogramAsyncStorage: NSObject {
    
    func performInBackground(task: () -> Void) {
        DispatchQueue.global(qos: .userInteractive).async({
            task()
        })
    }
    
    @objc(getItem)
    func getItem(key: String, onEnd: (StorageError?, String?) -> Void) -> String {
        performInBackground({
            onEnd(nil, UserDefaults.standard.string(forKey: key))
        })
    }
    
    @objc(setItem:item:)
    func setItem(key: String, value: String, onEnd: (StorageError?, Result?) -> Void) {
        performInBackground({
            UserDefaults.standard.set(value: value, forKey: key)
            onEnd(nil, Result(success: true))
        })
    }
    
    @objc(setMultipleItems:items:)
    func setMultipleItems(items: [(String,String)], onEnd: (StorageError?, Result?) -> Void) {
        performInBackground({
            items.forEach({ item in
                UserDefaults.standard.set(value: item.0, forKey: item.1)
            })
            onEnd(nil, Result(success: true))
        })
    }
    
    @objc(getMultipleItems)
    func getMultipleItems(keys: [String], onEnd: (StorageError?, [String]?) -> Void) -> [String] {
        performInBackground({
            onEnd(nil, keys.map({ key in
                UserDefaults.standard.string(forKey: key)
            }))
        })
    }
    
    struct Result {
        let success: Bool
    }
    
    struct StorageError {
        let message: String
    }
}
