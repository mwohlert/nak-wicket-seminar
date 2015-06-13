#Install

Here is a short tutorial on how to get this project up and running.

Untar und ungzip dataset.tar.gz

    tar xfvz dataset.tar.gz

Restore Dataset to your MongoDB (make sure you have mongodb-tools installed)

    mongorestore --port <port number> dataset/

You can delete the extracted files now

    rm -rf dataset/


Connect to your mongodb with the mongo client and confirm restore

    use Wicket
    db.product.find()

If you are using IntelliJ the artifact should already be configured. Just point the runscript to your Tomcat installation (works with tomcat8)