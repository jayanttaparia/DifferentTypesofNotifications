package com.jayanttaparia.differenttypesofnotifications;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Person;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_simple, btn_bigText, btn_bigPicture, btn_inbox, btn_messaging, btn_action;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_simple = (Button)findViewById(R.id.simpleNot);
        btn_bigText = (Button)findViewById(R.id.bigTextNot);
        btn_bigPicture = (Button)findViewById(R.id.bigPictureNot);
        btn_inbox = (Button)findViewById(R.id.inboxNot);
        btn_messaging = (Button)findViewById(R.id.messagingNot);
        btn_action = (Button)findViewById(R.id.actionNot);

    }


    public void buttonClicked(View view){

        switch (view.getId()){
            case R.id.simpleNot: simpleNotification();
                break;

            case R.id.bigTextNot: bigTextNotification();
                break;

            case R.id.bigPictureNot:bigPictureNotification();
                break;

            case R.id.inboxNot: inboxNotification();
                break;

            case R.id.messagingNot:messagingNotification();
                break;

            case R.id.actionNot:actionNotification();
                break;
        }

    }


    public void simpleNotification(){
        int notificationId = 0;
        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification builder = new Notification.Builder(this)
                .setContentTitle("Android Development Course")
                .setContentText("Become an Android Develper")
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true)
                .setSound(path)
                .build();


        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId,builder);
    }

    public void bigTextNotification(){
        int notificationId = 1;
        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification notification = new Notification.Builder(this)
                .setContentTitle("Big text notification")
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setSound(path)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true)
                .setStyle(new Notification.BigTextStyle().bigText(getResources().getString(R.string.long_quote)))
                .build();


        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId,notification);
    }

    public void bigPictureNotification(){
        int notificationId = 2;
        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Bitmap picture = BitmapFactory.decodeResource(getResources(),R.drawable.photo);

        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("Currency Image")
                .setSound(path)
                .setSmallIcon(android.R.drawable.sym_def_app_icon)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.logo))
                .setStyle(new Notification.BigPictureStyle().bigPicture(picture))
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true)
                .build();


        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId,notification);
    }

    public void inboxNotification(){
        int notificationId = 3;
        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification notification = new Notification.Builder(getApplicationContext())
                .setSmallIcon(R.drawable.logo)
                .setStyle(new Notification.InboxStyle().addLine("Hello").addLine("Are u there").setBigContentTitle("2 New messages for you").setSummaryText("Inbox"))
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.logo))
                .setAutoCancel(true)
                .build();


        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId,notification);
    }

    public void messagingNotification(){
        int notificationId = 4;
        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Notification notification = new Notification.Builder(getApplicationContext())
                .setSmallIcon(R.drawable.logo)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.logo))
                .setStyle(new Notification.MessagingStyle("Ali: ").setConversationTitle("Q&A Group")
                            .addMessage("This type of notification was introduced in Android N right?",0,"Umar: ")
                            .addMessage("Yes",0, "Ali: ")
                            .addMessage("The constructor is passed with the name of the current user, Right?",0,"Bilal: ")
                            .addMessage("True",0,"Ali: "))
                .setAutoCancel(true)
                .setSound(path)
                .build();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId,notification);
    }

    public void actionNotification(){
        int notificationId = 5;
        Uri path = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.google.com"));
        PendingIntent pendingIntent = PendingIntent.getActivity(this,0,intent,0);

        Notification notification = new Notification.Builder(getApplicationContext())
                .setContentTitle("Action Button")
                .setStyle(new Notification.BigTextStyle().bigText("Click to visit Google"))
                .addAction(android.R.drawable.ic_menu_view,"VIEW",pendingIntent)
                .setSmallIcon(R.drawable.logo)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(),R.drawable.photo))
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setAutoCancel(true)
                .setSound(path)
                .build();

        NotificationManager notificationManager = (NotificationManager)getSystemService(NOTIFICATION_SERVICE);
        notificationManager.notify(notificationId,notification);
    }

}
