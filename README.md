
# react-native-rnmentoringprogram-async-storage

## Getting started

`$ npm install react-native-rnmentoringprogram-async-storage --save`

### Mostly automatic installation

`$ react-native link react-native-rnmentoringprogram-async-storage`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-rnmentoringprogram-async-storage` and add `RNRnmentoringprogramAsyncStorage.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNRnmentoringprogramAsyncStorage.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNRnmentoringprogramAsyncStoragePackage;` to the imports at the top of the file
  - Add `new RNRnmentoringprogramAsyncStoragePackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-rnmentoringprogram-async-storage'
  	project(':react-native-rnmentoringprogram-async-storage').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-rnmentoringprogram-async-storage/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-rnmentoringprogram-async-storage')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNRnmentoringprogramAsyncStorage.sln` in `node_modules/react-native-rnmentoringprogram-async-storage/windows/RNRnmentoringprogramAsyncStorage.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Rnmentoringprogram.Async.Storage.RNRnmentoringprogramAsyncStorage;` to the usings at the top of the file
  - Add `new RNRnmentoringprogramAsyncStoragePackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import { NativeModules } from 'react-native';


class MyComp extends React.Component {
  async componentDidMount() {
    await NativeModules.RNRnmentoringprogramAsyncStorage.setItem(
      'someKey',
      'someValue',
    );
    const item = await NativeModules.RNRnmentoringprogramAsyncStorage.getItem(
      'someKey',
    );
    await NativeModules.RNRnmentoringprogramAsyncStorage.setMultipleItems([
      ['someKey1', 'someValue1'],
      ['someKey2', 'someValue2'],
    ]);
    const items = await NativeModules.RNRnmentoringprogramAsyncStorage.getMultipleItems(
      ['someKey1', 'someKey1'],
    );
    const item2 = await NativeModules.RNRnmentoringprogramAsyncStorage.getItem(
      'someKey2',
    );
    console.log('item: ', item);
    console.log('items: ', items);
    console.log('item2: ', item2);
  }  
  
  render() {}
}
```
  