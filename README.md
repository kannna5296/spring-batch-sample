# spring-batch-sample
SpringBatchのサンプル

## 環境案
・Azure Container Instance
・Azure WebJobs

★メリデメ知りたい。


## ContainerInstanceで動かすときのTodo
* ContainerInstance作成
* ContainerResitry作成
* AzureCLIインストール
* 手元でACRにPush（お試しイメージ)(練習)
```
//ACRにログイン(Portalからユーザ名、パスワード確認必要)
az acr login --name devacrsample
//公式のお試しイメージをPull
docker pull mcr.microsoft.com/hello-world
//タグ化
docker tag mcr.microsoft.com/hello-world {ログインサーバ名}/{リポジトリ名}:{切りたいタグ名}
//
docker push {ログインサーバ名}/{リポジトリ名}:{切りたいタグ名}
```
結果
<img width="861" alt="スクリーンショット 2022-03-26 10 06 46" src="https://user-images.githubusercontent.com/58777139/160218615-c988fab7-199b-47eb-8efa-d8ba35cff63f.png">
