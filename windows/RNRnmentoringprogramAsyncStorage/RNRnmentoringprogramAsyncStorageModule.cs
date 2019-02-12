using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Rnmentoringprogram.Async.Storage.RNRnmentoringprogramAsyncStorage
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNRnmentoringprogramAsyncStorageModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNRnmentoringprogramAsyncStorageModule"/>.
        /// </summary>
        internal RNRnmentoringprogramAsyncStorageModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNRnmentoringprogramAsyncStorage";
            }
        }
    }
}
