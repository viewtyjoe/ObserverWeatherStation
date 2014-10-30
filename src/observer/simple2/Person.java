package observer.simple2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * This class acts as a subscriber of information in the Observer pattern.
 * In the Observer pattern subscribers are called "Observer". Note the
 * implementation of the interface Subscriber. This is necessary so the
 * publisher component can act on common behaviors of all its subscribers.
 *
 * This class is implemented as a simple GUI showing the notifications sent
 * by the publisher in individual windows for each subscriber.
 *
 * @author jlombardo
 */
public class Person extends JFrame implements Subscriber {
    private String name;
    private JList inbox;
    private JScrollPane scrollPane;
    private DefaultListModel notifications;

    public Person(String name, int x, int y) {
        super(name + "'s Email Inbox");
        this.name = name;
        notifications = new DefaultListModel();
        inbox = new JList(notifications);
        scrollPane = new JScrollPane(inbox);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        setBounds(x, y, 500, 300);
        this.setPreferredSize(new Dimension(500,300));
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
    }

    /**
     * This method is dicated by the Subscriber interface which the Publisher
     * use to notify its subscriber list.
     *
     * @param publisher - the publisher or "Observable" object. OPtional.
     * @param info - any information the publisher wants to provide. Optional.
     */
    @Override
    public void update(Publisher publisher, final String info) {
        // This is how we update a JList on a separate thread
        // independent of the main app thread in StartProgram
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               notifications.addElement(info.toString());
            }
        });
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
