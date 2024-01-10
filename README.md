AIDlClientApp

We will create an AIDL client. The server app hosts a Bound Service and contains the logic to return random colours to its client. The client app calls the service and changes 
the button's colour within the Main activity.

What is AIDL?
The Android Interface Definition Language (AIDL) is similar to other IDLs: it lets you define the programming interface that both the client and service agree upon in order to communicate
with each other using interprocess communication (IPC).

On Android, one process can't normally access the memory of another process. To talk, they need to decompose their objects into primitives that the
operating system can understand and marshall the objects across that boundary for you. The code to do that marshalling is tedious to write, so Android handles it for you with AIDL.
