/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import javax.swing.UIManager;
import java.util.List;
import java.util.ArrayList;  
import java.util.ArrayList;
import java.util.TreeSet;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

import view.View;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import views.author.CreateAuthor;
import views.author.EditAuthor;

import views.book.CreateBook;
import views.book.EditBook;

import views.branch.CreateBranch;
import views.branch.EditBranch;

import views.category.CreateCategory;
import views.category.EditCategory;

import views.customer.CreateCustomer;
import views.customer.EditCustomer;

import views.employee.EditEmployee;
import views.employee.EditEmployee;

import views.order.CreateOrder;
import views.orderdetail.OrderDetail;

import views.publisher.CreatePublisher;
import views.publisher.EditPublisher;

import views.receipt.CreateReceipt;

import views.supplier.CreateSupplier;
import views.supplier.EditSupplier;


// Model
import models.Book;
import models.Author;
import models.Category;
import models.Branch;
import models.Customer;
import models.Employee;
import models.Order;
//import models.OrderDetail;
import models.Publisher;
import models.Receipt;
import models.Supplier;





// Controller
import controllers.book.BookController;
import controllers.author.AuthorController;
import controllers.category.CategoryController;
import controllers.branch.BranchController;
import controllers.customer.CustomerController;
import controllers.employee.EmployeeController;
import controllers.order.OrderController;
import controllers.publisher.PublisherController;
import controllers.reciept.ReceiptController;
import controllers.supplier.SupplierController;
import controllers.orderdetail.OrderDetailController;


import java.time.format.DateTimeFormatter;

/**
 *
 * @author Admin
 */



public class HomePage extends javax.swing.JFrame implements View {
    

    @Override
    public <T> void showData(ArrayList<T> list, DefaultTableModel model) {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        model.setRowCount(0);
        for (T t : list) {
            if (t instanceof Book) {
                Book b = (Book) t;
                tblModelSach.addRow(new Object[]{
                    b.getISBN(), b.getTitle(), b.getPublicationYear(), b.getAuthor(), b.getQuantityInStock(), b.getPrice()
                });

            }
            
            if (t instanceof Order) {
                Order b = (Order) t;
                tblModelOrder.addRow(new Object[]{
                    b.getOrderId(), b.getCustomer(), b.getAddress(), b.getPhone(), b.getOrderDate(), b.getTotalAmount()
                });

            }
            
            if (t instanceof Author) {
                Author a = (Author) t;
                tblModelAuthor.addRow(new Object[]{
                    a.getId(), a.getName(), a.getAddress(), a.getPhoneNumber(), a.getEmail(), a.getDate_of_birth()
                });

            }
            if (t instanceof Category ) {
                Category a = (Category) t;
                tblModelCategory.addRow(new Object[]{
                    a.getCateID(), a.getName(), a.getDescription()
                });

            }
            
            if (t instanceof Branch ) {
                Branch a = (Branch) t;
                tblModelBranch.addRow(new Object[]{
                    a.getName(), a.getAddress(), a.getManager(), a.getHotline(), a.getStatus()
                });

            }
            
            if (t instanceof Supplier ) {
                Supplier a = (Supplier) t;
                tblModelSupplier.addRow(new Object[]{
                    a.getId(), a.getName(), a.getAddress(), a.getPhoneNumber(), a.getEmail()
                });
            }
            
            if (t instanceof Publisher ) {
                Publisher a = (Publisher) t;
                tblModelPublisher.addRow(new Object[]{
                    a.getName(), a.getAddress(), a.getPhoneNumber(), a.getEmail()
                });
            }
            
            if (t instanceof Receipt ) {
                Receipt a = (Receipt) t;
                tblModelReceipt.addRow(new Object[]{
                    a.getReceiptId(), a.getReceiptDate(),a.getSupplier(), a.getBook(), a.getEmployee(), a.getQuantity(), a.getTotalPrice()
                });
            }
            
        }
    }

//    private ArrayList<Book> booklist;    
    public ArrayList<Book> book_list;
    public ArrayList<Author> author_list;
    public ArrayList<Category> category_list;
    public ArrayList<Branch> branch_list;
    public ArrayList<Customer> customer_list;
    public ArrayList<Employee> employee_list;
    public ArrayList<Order> order_list;
    public ArrayList<models.OrderDetail> order_detail_list;
    public ArrayList<Publisher> publisher_list;
    public ArrayList<Receipt> receipt_list;
    public ArrayList<Supplier> supplier_list;
    
    
    private int dongChon = -1;
    
    
    // Default table
    private DefaultTableModel tblModelSach;
    private DefaultTableModel tblModelAuthor;
    private DefaultTableModel tblModelCategory;
    private DefaultTableModel tblModelBranch;
    private DefaultTableModel tblModelCustomer;
    private DefaultTableModel tblModelEmployee;
    private DefaultTableModel tblModelOrder;
    private DefaultTableModel tblModelPublisher;
    private DefaultTableModel tblModelReceipt;
    private DefaultTableModel tblModelSupplier;
    
    // Controller
    
    private BookController bookController;
    private AuthorController authorController;
    private CategoryController categoryController;
    private BranchController branchController;
    private CustomerController customerController;
    private EmployeeController employeeController;
    private OrderController orderController;
    private OrderDetailController orderDetailController;
    private PublisherController publisherController;
    private ReceiptController receiptController;
    private SupplierController supplierController;
    
    
    /**
     * Creates new form HomePage
     */
    public HomePage() {
        
        
        initComponents();
        
        
        book_list = new ArrayList<>();
        author_list = new ArrayList<>();
        category_list = new ArrayList<>();
        branch_list = new ArrayList<>();
        customer_list = new ArrayList<>();
        employee_list = new ArrayList<>();
        order_list = new ArrayList<>();
        order_detail_list = new ArrayList<>();
        publisher_list = new ArrayList<>();
        receipt_list = new ArrayList<>();
        supplier_list = new ArrayList<>();
       
       // book
        tblModelSach = (DefaultTableModel) tblSach.getModel();
        this.bookController = new BookController();
        showBookList();
        
        // author
        tblModelAuthor = (DefaultTableModel) tblAuthor.getModel();
        this.authorController = new AuthorController();
        showAuthorList(); 
        
        // category
        tblModelCategory = (DefaultTableModel) tblCategory.getModel();
        this.categoryController = new CategoryController();
        showCategoryList(); 
        
        // branch
        tblModelBranch = (DefaultTableModel) tblBranch.getModel();
        this.branchController = new BranchController();
        showBranchList(); 
        
        // supplier
        tblModelSupplier = (DefaultTableModel) tblSupplier.getModel();
        this.supplierController = new SupplierController();
        showSupplierList(); 
        
        // receipt 
        tblModelReceipt = (DefaultTableModel) tblReceipt.getModel();
        this.receiptController = new ReceiptController();
        showReceiptList(); 
        
        // order 
        tblModelOrder = (DefaultTableModel) tblOrder.getModel();
        this.orderController = new OrderController();
        showOrderList(); 
        
        this.orderDetailController = new OrderDetailController();
        
        // supplier
//        tblModelPublisher = (DefaultTableModel) tblPublisher.getModel();
//        this.supplierController = new SupplierController();
//        showSupplierList(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        Panle_timKiem4 = new javax.swing.JPanel();
        txtSearch4 = new javax.swing.JTextField();
        btTimHD4 = new javax.swing.JButton();
        jPanel18 = new javax.swing.JPanel();
        btThemHD4 = new javax.swing.JButton();
        btSuaHD4 = new javax.swing.JButton();
        btXoaHD4 = new javax.swing.JButton();
        btnReset4 = new javax.swing.JButton();
        jPanel19 = new javax.swing.JPanel();
        comboSapXepBook = new javax.swing.JComboBox<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        tblSach = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        Panle_timKiem5 = new javax.swing.JPanel();
        txtSearchAuthor = new javax.swing.JTextField();
        btTimHD5 = new javax.swing.JButton();
        jPanel20 = new javax.swing.JPanel();
        btThemHD5 = new javax.swing.JButton();
        btSuaHD5 = new javax.swing.JButton();
        btXoaHD5 = new javax.swing.JButton();
        btnReset5 = new javax.swing.JButton();
        jPanel21 = new javax.swing.JPanel();
        comboSapXepAuthor = new javax.swing.JComboBox<>();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblAuthor = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        Panle_timKiem = new javax.swing.JPanel();
        txtSearchCategory = new javax.swing.JTextField();
        btTimHD = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        btThemHD = new javax.swing.JButton();
        btSuaHD = new javax.swing.JButton();
        btXoaHD = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblCategory = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jPanel23 = new javax.swing.JPanel();
        comboSapXepCategory = new javax.swing.JComboBox<>();
        jPanel8 = new javax.swing.JPanel();
        Panle_timKiem1 = new javax.swing.JPanel();
        txtSearchSupplier = new javax.swing.JTextField();
        btTimHD1 = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        btThemHD1 = new javax.swing.JButton();
        btSuaHD1 = new javax.swing.JButton();
        btXoaHD1 = new javax.swing.JButton();
        btnReset1 = new javax.swing.JButton();
        jPanel12 = new javax.swing.JPanel();
        comboSapXepSupplier = new javax.swing.JComboBox<>();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblSupplier = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        iPanel9 = new javax.swing.JPanel();
        Panle_timKiem2 = new javax.swing.JPanel();
        RadioSearchByMaHD2 = new javax.swing.JRadioButton();
        RadioSearchByKH2 = new javax.swing.JRadioButton();
        txtSearch2 = new javax.swing.JTextField();
        btTimHD2 = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        btThemHD2 = new javax.swing.JButton();
        btXoaHD2 = new javax.swing.JButton();
        btXemChiTietHD2 = new javax.swing.JButton();
        btnReset2 = new javax.swing.JButton();
        jPanel15 = new javax.swing.JPanel();
        RadioSortTT2 = new javax.swing.JRadioButton();
        RadioSortByTime2 = new javax.swing.JRadioButton();
        jbtXep2 = new javax.swing.JButton();
        jScrollPane7 = new javax.swing.JScrollPane();
        tblOrder = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        iPanel11 = new javax.swing.JPanel();
        Panle_timKiem6 = new javax.swing.JPanel();
        txtSearchBranch = new javax.swing.JTextField();
        btTimHD6 = new javax.swing.JButton();
        jPanel22 = new javax.swing.JPanel();
        btThemHD6 = new javax.swing.JButton();
        btSuaHD6 = new javax.swing.JButton();
        btXoaHD6 = new javax.swing.JButton();
        btnReset6 = new javax.swing.JButton();
        jScrollPane11 = new javax.swing.JScrollPane();
        tblBranch = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        iPanel10 = new javax.swing.JPanel();
        Panle_timKiem3 = new javax.swing.JPanel();
        txtSearch3 = new javax.swing.JTextField();
        btTimHD3 = new javax.swing.JButton();
        jPanel16 = new javax.swing.JPanel();
        btThemHD3 = new javax.swing.JButton();
        btXoaHD3 = new javax.swing.JButton();
        btnReset3 = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblReceipt = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("TRANG CHỦ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(493, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Trang chủ", jPanel2);

        Panle_timKiem4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        Panle_timKiem4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSearch4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btTimHD4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btTimHD4.setText("Tìm");
        btTimHD4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimHD4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panle_timKiem4Layout = new javax.swing.GroupLayout(Panle_timKiem4);
        Panle_timKiem4.setLayout(Panle_timKiem4Layout);
        Panle_timKiem4Layout.setHorizontalGroup(
            Panle_timKiem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panle_timKiem4Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(Panle_timKiem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panle_timKiem4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btTimHD4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtSearch4))
                .addGap(31, 31, 31))
        );
        Panle_timKiem4Layout.setVerticalGroup(
            Panle_timKiem4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panle_timKiem4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearch4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btTimHD4)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btThemHD4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btThemHD4.setText("Thêm");
        btThemHD4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemHD4ActionPerformed(evt);
            }
        });
        jPanel18.add(btThemHD4);

        btSuaHD4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSuaHD4.setText("Sửa");
        btSuaHD4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaHD4ActionPerformed(evt);
            }
        });
        jPanel18.add(btSuaHD4);

        btXoaHD4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btXoaHD4.setText("Xóa");
        btXoaHD4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaHD4ActionPerformed(evt);
            }
        });
        jPanel18.add(btXoaHD4);

        btnReset4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset4.setText("Refresh");
        btnReset4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset4ActionPerformed(evt);
            }
        });
        jPanel18.add(btnReset4);

        jPanel19.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp xếp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel19.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        comboSapXepBook.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboSapXepBook.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tăng dần giá bán", "Giảm dần giá bán"}));
        comboSapXepBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSapXepBookActionPerformed(evt);
            }
        });
        comboSapXepBook.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboSapXepBookPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSapXepBook, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(comboSapXepBook, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tblSach.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        tblSach.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ISBN", "Tên sách", "Ngày phát hành", "Tác giả", "Số lượng", "Giá bán"
            }
        ));
        tblSach.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSachMouseClicked(evt);
            }
        });
        jScrollPane9.setViewportView(tblSach);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("QUẢN LÝ SÁCH");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Panle_timKiem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 398, Short.MAX_VALUE)
                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane9, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Panle_timKiem4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane9, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel18, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        Panle_timKiem4.getAccessibleContext().setAccessibleName("Tìm kiếm sách");
        Panle_timKiem4.getAccessibleContext().setAccessibleDescription("");

        jTabbedPane1.addTab("Quản lý sách", jPanel5);

        Panle_timKiem5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        Panle_timKiem5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSearchAuthor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btTimHD5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btTimHD5.setText("Tìm");
        btTimHD5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimHD5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panle_timKiem5Layout = new javax.swing.GroupLayout(Panle_timKiem5);
        Panle_timKiem5.setLayout(Panle_timKiem5Layout);
        Panle_timKiem5Layout.setHorizontalGroup(
            Panle_timKiem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panle_timKiem5Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(Panle_timKiem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtSearchAuthor, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btTimHD5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );
        Panle_timKiem5Layout.setVerticalGroup(
            Panle_timKiem5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panle_timKiem5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btTimHD5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btThemHD5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btThemHD5.setText("Thêm");
        btThemHD5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemHD5ActionPerformed(evt);
            }
        });
        jPanel20.add(btThemHD5);

        btSuaHD5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSuaHD5.setText("Sửa");
        btSuaHD5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaHD5ActionPerformed(evt);
            }
        });
        jPanel20.add(btSuaHD5);

        btXoaHD5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btXoaHD5.setText("Xóa");
        btXoaHD5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaHD5ActionPerformed(evt);
            }
        });
        jPanel20.add(btXoaHD5);

        btnReset5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset5.setText("Refresh");
        btnReset5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset5ActionPerformed(evt);
            }
        });
        jPanel20.add(btnReset5);

        jPanel21.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp xếp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel21.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        comboSapXepAuthor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboSapXepAuthor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên từ A-Z", "Tên từ Z-A"}));
        comboSapXepAuthor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSapXepAuthorActionPerformed(evt);
            }
        });
        comboSapXepAuthor.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboSapXepAuthorPropertyChange(evt);
            }
        });
        comboSapXepAuthor.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                comboSapXepAuthorVetoableChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel21Layout = new javax.swing.GroupLayout(jPanel21);
        jPanel21.setLayout(jPanel21Layout);
        jPanel21Layout.setHorizontalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSapXepAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel21Layout.setVerticalGroup(
            jPanel21Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel21Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(comboSapXepAuthor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tblAuthor.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        tblAuthor.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblAuthor.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Họ tên", "Địa chỉ", "SĐT", "Email", "Ngày sinh"
            }
        ));
        tblAuthor.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblAuthor.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblAuthorMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblAuthor);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("QUẢN LÝ TÁC GIẢ");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Panle_timKiem5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panle_timKiem5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(61, Short.MAX_VALUE))
        );

        Panle_timKiem5.getAccessibleContext().setAccessibleName("Tìm kiếm tác giả");

        jTabbedPane1.addTab("Quản lý tác giả", jPanel6);

        Panle_timKiem.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        Panle_timKiem.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSearchCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchCategoryActionPerformed(evt);
            }
        });

        btTimHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btTimHD.setText("Tìm");
        btTimHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimHDActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panle_timKiemLayout = new javax.swing.GroupLayout(Panle_timKiem);
        Panle_timKiem.setLayout(Panle_timKiemLayout);
        Panle_timKiemLayout.setHorizontalGroup(
            Panle_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panle_timKiemLayout.createSequentialGroup()
                .addGroup(Panle_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panle_timKiemLayout.createSequentialGroup()
                        .addContainerGap(159, Short.MAX_VALUE)
                        .addComponent(btTimHD, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panle_timKiemLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtSearchCategory)))
                .addGap(30, 30, 30))
        );
        Panle_timKiemLayout.setVerticalGroup(
            Panle_timKiemLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panle_timKiemLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btTimHD)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        btThemHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btThemHD.setText("Thêm");
        btThemHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemHDActionPerformed(evt);
            }
        });
        jPanel9.add(btThemHD);

        btSuaHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSuaHD.setText("Sửa");
        btSuaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaHDActionPerformed(evt);
            }
        });
        jPanel9.add(btSuaHD);

        btXoaHD.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btXoaHD.setText("Xóa");
        btXoaHD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaHDActionPerformed(evt);
            }
        });
        jPanel9.add(btXoaHD);

        btnReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset.setText("Refresh");
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });
        jPanel9.add(btnReset);

        tblCategory.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        tblCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblCategory.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên danh mục", "Mô tả"
            }
        ));
        tblCategory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblCategory.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCategoryMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tblCategory);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("QUẢN LÝ DANH MỤC");

        jPanel23.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp xếp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel23.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        comboSapXepCategory.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboSapXepCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên từ A-Z", "Tên từ Z-A"}));
        comboSapXepCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSapXepCategoryActionPerformed(evt);
            }
        });
        comboSapXepCategory.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboSapXepCategoryPropertyChange(evt);
            }
        });
        comboSapXepCategory.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                comboSapXepCategoryVetoableChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel23Layout = new javax.swing.GroupLayout(jPanel23);
        jPanel23.setLayout(jPanel23Layout);
        jPanel23Layout.setHorizontalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSapXepCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel23Layout.setVerticalGroup(
            jPanel23Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel23Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(comboSapXepCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Panle_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Panle_timKiem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý danh mục", jPanel7);

        Panle_timKiem1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        Panle_timKiem1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSearchSupplier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        txtSearchSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSearchSupplierActionPerformed(evt);
            }
        });

        btTimHD1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btTimHD1.setText("Tìm");
        btTimHD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimHD1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panle_timKiem1Layout = new javax.swing.GroupLayout(Panle_timKiem1);
        Panle_timKiem1.setLayout(Panle_timKiem1Layout);
        Panle_timKiem1Layout.setHorizontalGroup(
            Panle_timKiem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panle_timKiem1Layout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(Panle_timKiem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btTimHD1, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtSearchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18))
        );
        Panle_timKiem1Layout.setVerticalGroup(
            Panle_timKiem1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panle_timKiem1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(txtSearchSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btTimHD1)
                .addContainerGap(13, Short.MAX_VALUE))
        );

        btThemHD1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btThemHD1.setText("Thêm");
        btThemHD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemHD1ActionPerformed(evt);
            }
        });
        jPanel11.add(btThemHD1);

        btSuaHD1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSuaHD1.setText("Sửa");
        btSuaHD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaHD1ActionPerformed(evt);
            }
        });
        jPanel11.add(btSuaHD1);

        btXoaHD1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btXoaHD1.setText("Xóa");
        btXoaHD1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaHD1ActionPerformed(evt);
            }
        });
        jPanel11.add(btXoaHD1);

        btnReset1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset1.setText("Refresh");
        btnReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset1ActionPerformed(evt);
            }
        });
        jPanel11.add(btnReset1);

        jPanel12.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp xếp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel12.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        comboSapXepSupplier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        comboSapXepSupplier.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tên từ A-Z", "Tên từ Z-A"}));
        comboSapXepSupplier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboSapXepSupplierActionPerformed(evt);
            }
        });
        comboSapXepSupplier.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboSapXepSupplierPropertyChange(evt);
            }
        });
        comboSapXepSupplier.addVetoableChangeListener(new java.beans.VetoableChangeListener() {
            public void vetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {
                comboSapXepSupplierVetoableChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(comboSapXepSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(comboSapXepSupplier, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(19, Short.MAX_VALUE))
        );

        tblSupplier.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        tblSupplier.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblSupplier.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "NCC", "Địa chỉ", "Điện thoại", "Email"
            }
        ));
        tblSupplier.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblSupplier.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSupplierMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tblSupplier);
        if (tblSupplier.getColumnModel().getColumnCount() > 0) {
            tblSupplier.getColumnModel().getColumn(0).setResizable(false);
            tblSupplier.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("QUẢN LÝ NHÀ CUNG CẤP");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Panle_timKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Panle_timKiem1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý NCC", jPanel8);

        Panle_timKiem2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        Panle_timKiem2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        RadioSearchByMaHD2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RadioSearchByMaHD2.setText("Mã HĐ");

        RadioSearchByKH2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RadioSearchByKH2.setText("Khách hàng");

        txtSearch2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btTimHD2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btTimHD2.setText("Tìm");
        btTimHD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimHD2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panle_timKiem2Layout = new javax.swing.GroupLayout(Panle_timKiem2);
        Panle_timKiem2.setLayout(Panle_timKiem2Layout);
        Panle_timKiem2Layout.setHorizontalGroup(
            Panle_timKiem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panle_timKiem2Layout.createSequentialGroup()
                .addGroup(Panle_timKiem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panle_timKiem2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btTimHD2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panle_timKiem2Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(Panle_timKiem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearch2)
                            .addGroup(Panle_timKiem2Layout.createSequentialGroup()
                                .addComponent(RadioSearchByMaHD2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                                .addComponent(RadioSearchByKH2)))))
                .addGap(30, 30, 30))
        );
        Panle_timKiem2Layout.setVerticalGroup(
            Panle_timKiem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panle_timKiem2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panle_timKiem2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RadioSearchByMaHD2)
                    .addComponent(RadioSearchByKH2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtSearch2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btTimHD2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btThemHD2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btThemHD2.setText("Thêm");
        btThemHD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemHD2ActionPerformed(evt);
            }
        });
        jPanel14.add(btThemHD2);

        btXoaHD2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btXoaHD2.setText("Xóa");
        btXoaHD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaHD2ActionPerformed(evt);
            }
        });
        jPanel14.add(btXoaHD2);

        btXemChiTietHD2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btXemChiTietHD2.setText("Xem chi tiết");
        btXemChiTietHD2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXemChiTietHD2ActionPerformed(evt);
            }
        });
        jPanel14.add(btXemChiTietHD2);

        btnReset2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset2.setText("Refresh");
        btnReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset2ActionPerformed(evt);
            }
        });
        jPanel14.add(btnReset2);

        jPanel15.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Sắp xếp", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        jPanel15.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        RadioSortTT2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RadioSortTT2.setText("Tăng dần theo tổng thanh toán");

        RadioSortByTime2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RadioSortByTime2.setText("Thời gian gần nhất");

        jbtXep2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jbtXep2.setText("Xếp");
        jbtXep2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtXep2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtXep2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(RadioSortTT2)
                        .addComponent(RadioSortByTime2)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(RadioSortTT2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(RadioSortByTime2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtXep2)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tblOrder.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        tblOrder.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblOrder.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Khách hàng", "Địa chỉ", "SĐT", "Thời gian", "Tổng thanh toán"
            }
        ));
        tblOrder.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblOrder.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblOrderMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tblOrder);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("QUẢN LÝ ĐƠN HÀNG");

        javax.swing.GroupLayout iPanel9Layout = new javax.swing.GroupLayout(iPanel9);
        iPanel9.setLayout(iPanel9Layout);
        iPanel9Layout.setHorizontalGroup(
            iPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(iPanel9Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Panle_timKiem2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36))
            .addComponent(jScrollPane7, javax.swing.GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        iPanel9Layout.setVerticalGroup(
            iPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iPanel9Layout.createSequentialGroup()
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(iPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(Panle_timKiem2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý đơn hàng", iPanel9);

        Panle_timKiem6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        Panle_timKiem6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSearchBranch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btTimHD6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btTimHD6.setText("Tìm");
        btTimHD6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimHD6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panle_timKiem6Layout = new javax.swing.GroupLayout(Panle_timKiem6);
        Panle_timKiem6.setLayout(Panle_timKiem6Layout);
        Panle_timKiem6Layout.setHorizontalGroup(
            Panle_timKiem6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panle_timKiem6Layout.createSequentialGroup()
                .addGroup(Panle_timKiem6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panle_timKiem6Layout.createSequentialGroup()
                        .addContainerGap(199, Short.MAX_VALUE)
                        .addComponent(btTimHD6, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panle_timKiem6Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtSearchBranch)))
                .addGap(30, 30, 30))
        );
        Panle_timKiem6Layout.setVerticalGroup(
            Panle_timKiem6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panle_timKiem6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtSearchBranch, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btTimHD6)
                .addContainerGap(15, Short.MAX_VALUE))
        );

        btThemHD6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btThemHD6.setText("Thêm");
        btThemHD6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemHD6ActionPerformed(evt);
            }
        });
        jPanel22.add(btThemHD6);

        btSuaHD6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btSuaHD6.setText("Sửa");
        btSuaHD6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaHD6ActionPerformed(evt);
            }
        });
        jPanel22.add(btSuaHD6);

        btXoaHD6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btXoaHD6.setText("Xóa");
        btXoaHD6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaHD6ActionPerformed(evt);
            }
        });
        jPanel22.add(btXoaHD6);

        btnReset6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset6.setText("Refresh");
        btnReset6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset6ActionPerformed(evt);
            }
        });
        jPanel22.add(btnReset6);

        tblBranch.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        tblBranch.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblBranch.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Chi nhánh", "Địa chỉ", "Quản lý", "Hotline", "Trạng thái"
            }
        ));
        tblBranch.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblBranch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblBranchMouseClicked(evt);
            }
        });
        jScrollPane11.setViewportView(tblBranch);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("QUẢN LÝ CHI NHÁNH");

        javax.swing.GroupLayout iPanel11Layout = new javax.swing.GroupLayout(iPanel11);
        iPanel11.setLayout(iPanel11Layout);
        iPanel11Layout.setHorizontalGroup(
            iPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel22, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(iPanel11Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Panle_timKiem6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 604, Short.MAX_VALUE))
            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iPanel11Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane11, javax.swing.GroupLayout.DEFAULT_SIZE, 951, Short.MAX_VALUE)
                .addContainerGap())
        );
        iPanel11Layout.setVerticalGroup(
            iPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iPanel11Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panle_timKiem6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jPanel22, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Quản lý chi nhánh", iPanel11);

        Panle_timKiem3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Tìm kiếm hóa đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14))); // NOI18N
        Panle_timKiem3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        txtSearch3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        btTimHD3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btTimHD3.setText("Tìm");
        btTimHD3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTimHD3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout Panle_timKiem3Layout = new javax.swing.GroupLayout(Panle_timKiem3);
        Panle_timKiem3.setLayout(Panle_timKiem3Layout);
        Panle_timKiem3Layout.setHorizontalGroup(
            Panle_timKiem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panle_timKiem3Layout.createSequentialGroup()
                .addGroup(Panle_timKiem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panle_timKiem3Layout.createSequentialGroup()
                        .addContainerGap(159, Short.MAX_VALUE)
                        .addComponent(btTimHD3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(Panle_timKiem3Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(txtSearch3)))
                .addGap(30, 30, 30))
        );
        Panle_timKiem3Layout.setVerticalGroup(
            Panle_timKiem3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panle_timKiem3Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(txtSearch3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btTimHD3)
                .addContainerGap(11, Short.MAX_VALUE))
        );

        btThemHD3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btThemHD3.setText("Thêm");
        btThemHD3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemHD3ActionPerformed(evt);
            }
        });
        jPanel16.add(btThemHD3);

        btXoaHD3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btXoaHD3.setText("Xóa");
        btXoaHD3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaHD3ActionPerformed(evt);
            }
        });
        jPanel16.add(btXoaHD3);

        btnReset3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        btnReset3.setText("Refresh");
        btnReset3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset3ActionPerformed(evt);
            }
        });
        jPanel16.add(btnReset3);

        tblReceipt.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 14)), "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 0, 18))); // NOI18N
        tblReceipt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        tblReceipt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã hóa đơn", "Ngày nhập", "Nhà cung cấp", "Sách", "Phụ trách", "Số lượng", "Tổng tiền"
            }
        ));
        tblReceipt.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tblReceipt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblReceiptMouseClicked(evt);
            }
        });
        jScrollPane8.setViewportView(tblReceipt);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("NHẬP KHO");

        javax.swing.GroupLayout iPanel10Layout = new javax.swing.GroupLayout(iPanel10);
        iPanel10.setLayout(iPanel10Layout);
        iPanel10Layout.setHorizontalGroup(
            iPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(iPanel10Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(Panle_timKiem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 644, Short.MAX_VALUE))
            .addComponent(jScrollPane8)
            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        iPanel10Layout.setVerticalGroup(
            iPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, iPanel10Layout.createSequentialGroup()
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Panle_timKiem3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Nhập kho", iPanel10);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tblReceiptMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblReceiptMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblReceiptMouseClicked

    private void btnReset3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset3ActionPerformed
        receipt_list = (ArrayList<Receipt>) receiptController.readDataFromFile("receipts.txt");
        this.showData(receipt_list, tblModelReceipt);
    }//GEN-LAST:event_btnReset3ActionPerformed

    private void btThemHD3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemHD3ActionPerformed
        CreateReceipt createB = new CreateReceipt(this, rootPaneCheckingEnabled);
        createB.setVisible(true);
    }//GEN-LAST:event_btThemHD3ActionPerformed

    private void btTimHD3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimHD3ActionPerformed
        receipt_list = (ArrayList<Receipt>) receiptController.readDataFromFile("receipts.txt");
        
        int searchKey = Integer.parseInt(txtSearchSupplier.getText());
        
        receipt_list = receiptController.searchReceipt(receipt_list, searchKey);
        if (receipt_list == null) {
            receipt_list = new ArrayList<>();
        }
        this.showData(receipt_list, tblModelReceipt);
    }//GEN-LAST:event_btTimHD3ActionPerformed

    private void tblBranchMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblBranchMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblBranchMouseClicked

    private void btnReset6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset6ActionPerformed
        branch_list = (ArrayList<Branch>) branchController.readDataFromFile("branches.txt");
        this.showData(branch_list, tblModelBranch);
    }//GEN-LAST:event_btnReset6ActionPerformed

    private void btXoaHD6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaHD6ActionPerformed
        //        Lấy ra chỉ số dòng chọn của người dùng click vào
        dongChon = tblBranch.getSelectedRow();
        /*       Nếu danh sách rỗng hoặc người dùng chưa chọn dòng  thì in ra thông báo
        còn nếu không thì show ra màn hình xác nhận xóa */
        if (dongChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng cần xóa!");
        } else if (branch_list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa!");
        } else {
            int confirm = JOptionPane.showConfirmDialog(
                rootPane,
                "Bạn có chắc chắn muốn xóa?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION
            );
            /*           Người dùng chọn Yes sẽ tiến hành xóa thông tin khỏi danh sách và
            show lại danh sách sau khi xóa */
            if (confirm == JOptionPane.YES_OPTION) {
                branch_list.remove(dongChon);
                categoryController.writeToFile(branch_list, "branches.txt");
                this.showData(branch_list, tblModelBranch);
            }
        }
    }//GEN-LAST:event_btXoaHD6ActionPerformed

    private void btSuaHD6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaHD6ActionPerformed
        //        Lấy ra chỉ số dòng chọn của người dùng click vào
        dongChon = tblBranch.getSelectedRow();
        /*       Nếu danh sách rỗng hoặc người dùng chưa chọn dòng  thì in ra thông báo
        còn nếu không thì gọi đến màn hình sửa */
        if (branch_list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin để sửa!");
        } else if (dongChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn dòng chứa thông tin cần sửa!");
        } else {
            EditBranch sua = new EditBranch(this, rootPaneCheckingEnabled);
            sua.setEditData(branch_list.get(dongChon));
            sua.setVisible(true);
        }
    }//GEN-LAST:event_btSuaHD6ActionPerformed

    private void btThemHD6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemHD6ActionPerformed
        CreateBranch createB = new CreateBranch(this, rootPaneCheckingEnabled);
        createB.setVisible(true);
    }//GEN-LAST:event_btThemHD6ActionPerformed

    private void btTimHD6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimHD6ActionPerformed
        branch_list = (ArrayList<Branch>) branchController.readDataFromFile("branches.txt");
        
        String searchKey = txtSearchBranch.getText();
        
        branch_list = branchController.searchBranch(branch_list, searchKey);
        if (branch_list == null) {
            branch_list = new ArrayList<>();
        }
        this.showData(branch_list, tblModelBranch);
    }//GEN-LAST:event_btTimHD6ActionPerformed

    private void tblOrderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblOrderMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblOrderMouseClicked

    private void jbtXep2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtXep2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jbtXep2ActionPerformed

    private void btnReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnReset2ActionPerformed

    private void btXemChiTietHD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXemChiTietHD2ActionPerformed
        dongChon = tblOrder.getSelectedRow();
        /*       Nếu danh sách rỗng hoặc người dùng chưa chọn dòng  thì in ra thông báo
        còn nếu không thì gọi đến màn hình sửa */
        if (order_list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin để sửa!");
        } else if (dongChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn dòng chứa thông tin cần sửa!");
        } else {
            OrderDetail dt = new OrderDetail(this, rootPaneCheckingEnabled);
            dt.setEditData(order_list.get(dongChon));
            dt.setVisible(true);
        }
    }//GEN-LAST:event_btXemChiTietHD2ActionPerformed

    private void btXoaHD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaHD2ActionPerformed
        //        Lấy ra chỉ số dòng chọn của người dùng click vào
        dongChon = tblOrder.getSelectedRow();
        /*       Nếu danh sách rỗng hoặc người dùng chưa chọn dòng  thì in ra thông báo
        còn nếu không thì show ra màn hình xác nhận xóa */
        if (dongChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng cần xóa!");
        } else if (order_list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa!");
        } else {
            int confirm = JOptionPane.showConfirmDialog(
                rootPane,
                "Bạn có chắc chắn muốn xóa?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION
            );
            /*           Người dùng chọn Yes sẽ tiến hành xóa thông tin khỏi danh sách và
            show lại danh sách sau khi xóa */
            if (confirm == JOptionPane.YES_OPTION) {
                order_list.remove(dongChon);
                orderController.writeToFile(order_list, "orders.txt");
                this.showData(order_list, tblModelOrder);
            }
        }
    }//GEN-LAST:event_btXoaHD2ActionPerformed

    private void btThemHD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemHD2ActionPerformed
        CreateOrder createB = new CreateOrder(this, rootPaneCheckingEnabled);
        createB.setVisible(true);

    }//GEN-LAST:event_btThemHD2ActionPerformed

    private void btTimHD2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimHD2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btTimHD2ActionPerformed

    private void tblSupplierMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSupplierMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSupplierMouseClicked

    private void btnReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset1ActionPerformed
       supplier_list = (ArrayList<Supplier>) supplierController.readDataFromFile("suppliers.txt");
       this.showData(supplier_list, tblModelSupplier);
    }//GEN-LAST:event_btnReset1ActionPerformed

    private void btXoaHD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaHD1ActionPerformed
        //        Lấy ra chỉ số dòng chọn của người dùng click vào
        dongChon = tblSupplier.getSelectedRow();
        /*       Nếu danh sách rỗng hoặc người dùng chưa chọn dòng  thì in ra thông báo
        còn nếu không thì show ra màn hình xác nhận xóa */
        if (dongChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng cần xóa!");
        } else if (supplier_list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa!");
        } else {
            int confirm = JOptionPane.showConfirmDialog(
                rootPane,
                "Bạn có chắc chắn muốn xóa?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION
            );
            /*           Người dùng chọn Yes sẽ tiến hành xóa thông tin khỏi danh sách và
            show lại danh sách sau khi xóa */
            if (confirm == JOptionPane.YES_OPTION) {
                supplier_list.remove(dongChon);
                supplierController.writeToFile(supplier_list, "suppliers.txt");
                this.showData(supplier_list, tblModelSupplier);
            }
        }
    }//GEN-LAST:event_btXoaHD1ActionPerformed

    private void btSuaHD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaHD1ActionPerformed
       dongChon = tblSupplier.getSelectedRow();
        /*       Nếu danh sách rỗng hoặc người dùng chưa chọn dòng  thì in ra thông báo
        còn nếu không thì gọi đến màn hình sửa */
        if (supplier_list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin xe để sửa!");
        } else if (dongChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn dòng chứa thông tin cần sửa!");
        } else {
            EditSupplier sua = new EditSupplier(this, rootPaneCheckingEnabled);
            sua.setEditData(supplier_list.get(dongChon));
            sua.setVisible(true);
        }
    }//GEN-LAST:event_btSuaHD1ActionPerformed

    private void btThemHD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemHD1ActionPerformed
        CreateSupplier createB = new CreateSupplier(this, rootPaneCheckingEnabled);
        createB.setVisible(true);
    }//GEN-LAST:event_btThemHD1ActionPerformed

    private void btTimHD1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimHD1ActionPerformed
        supplier_list = (ArrayList<Supplier>) supplierController.readDataFromFile("suppliers.txt");
        
        String searchKey = txtSearchSupplier.getText();
        
        supplier_list = supplierController.searchSupplier(supplier_list, searchKey);
        if (supplier_list == null) {
            supplier_list = new ArrayList<>();
        }
        this.showData(supplier_list, tblModelSupplier);
    }//GEN-LAST:event_btTimHD1ActionPerformed

    private void tblCategoryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCategoryMouseClicked

    }//GEN-LAST:event_tblCategoryMouseClicked

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        category_list = (ArrayList<Category>) categoryController.readDataFromFile("categories.txt");
        this.showData(category_list, tblModelCategory);
    }//GEN-LAST:event_btnResetActionPerformed

    private void btXoaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaHDActionPerformed
        //        Lấy ra chỉ số dòng chọn của người dùng click vào
        dongChon = tblCategory.getSelectedRow();
        /*       Nếu danh sách rỗng hoặc người dùng chưa chọn dòng  thì in ra thông báo
        còn nếu không thì show ra màn hình xác nhận xóa */
        if (dongChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng cần xóa!");
        } else if (category_list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa!");
        } else {
            int confirm = JOptionPane.showConfirmDialog(
                rootPane,
                "Bạn có chắc chắn muốn xóa?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION
            );
            /*           Người dùng chọn Yes sẽ tiến hành xóa thông tin khỏi danh sách và
            show lại danh sách sau khi xóa */
            if (confirm == JOptionPane.YES_OPTION) {
                category_list.remove(dongChon);
                categoryController.writeToFile(category_list, "categories.txt");
                this.showData(category_list, tblModelCategory);
            }
        }
    }//GEN-LAST:event_btXoaHDActionPerformed

    private void btSuaHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaHDActionPerformed
        //        Lấy ra chỉ số dòng chọn của người dùng click vào 
        dongChon = tblCategory.getSelectedRow();
        /*       Nếu danh sách rỗng hoặc người dùng chưa chọn dòng  thì in ra thông báo
        còn nếu không thì gọi đến màn hình sửa */
        if (category_list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin xe để sửa!");
        } else if (dongChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn dòng chứa thông tin cần sửa!");
        } else {
            EditCategory sua = new EditCategory(this, rootPaneCheckingEnabled);
            sua.setEditData(category_list.get(dongChon));
            sua.setVisible(true);
        }
    }//GEN-LAST:event_btSuaHDActionPerformed

    private void btThemHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemHDActionPerformed
        CreateCategory createB = new CreateCategory(this, rootPaneCheckingEnabled);
        createB.setVisible(true);
    }//GEN-LAST:event_btThemHDActionPerformed

    private void btTimHDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimHDActionPerformed
       category_list = (ArrayList<Category>) categoryController.readDataFromFile("categories.txt");
        
        String searchKey = txtSearchCategory.getText();
        System.out.println(searchKey);
        
        category_list = categoryController.searchCategory(category_list, searchKey);
        if (category_list == null) {
            category_list = new ArrayList<>();
        }
        this.showData(category_list, tblModelCategory);
    }//GEN-LAST:event_btTimHDActionPerformed

    private void txtSearchCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchCategoryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchCategoryActionPerformed

    private void tblAuthorMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblAuthorMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblAuthorMouseClicked

    private void btnReset5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset5ActionPerformed
        author_list = (ArrayList<Author>) authorController.readDataFromFile("authors.txt");
        this.showData(author_list, tblModelAuthor);
    }//GEN-LAST:event_btnReset5ActionPerformed

    private void btXoaHD5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaHD5ActionPerformed
        //        Lấy ra chỉ số dòng chọn của người dùng click vào
        dongChon = tblAuthor.getSelectedRow();
        /*       Nếu danh sách rỗng hoặc người dùng chưa chọn dòng  thì in ra thông báo
        còn nếu không thì show ra màn hình xác nhận xóa */
        if (dongChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng cần xóa!");
        } else if (author_list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa!");
        } else {
            int confirm = JOptionPane.showConfirmDialog(
                rootPane,
                "Bạn có chắc chắn muốn xóa?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION
            );
            /*           Người dùng chọn Yes sẽ tiến hành xóa thông tin khỏi danh sách và
            show lại danh sách sau khi xóa */
            if (confirm == JOptionPane.YES_OPTION) {
                author_list.remove(dongChon);
                authorController.writeToFile(author_list, "authors.txt");
                this.showData(author_list, tblModelAuthor);
            }
        }
    }//GEN-LAST:event_btXoaHD5ActionPerformed

    private void btSuaHD5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaHD5ActionPerformed
        //        Lấy ra chỉ số dòng chọn của người dùng click vào 
        dongChon = tblAuthor.getSelectedRow();
        /*       Nếu danh sách rỗng hoặc người dùng chưa chọn dòng  thì in ra thông báo
        còn nếu không thì gọi đến màn hình sửa */
        if (author_list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin xe để sửa!");
        } else if (dongChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn dòng chứa thông tin cần sửa!");
        } else {
            EditAuthor sua = new EditAuthor(this, rootPaneCheckingEnabled);
            sua.setEditData(author_list.get(dongChon));
            sua.setVisible(true);
        }
    }//GEN-LAST:event_btSuaHD5ActionPerformed

    private void btThemHD5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemHD5ActionPerformed
        CreateAuthor createB = new CreateAuthor(this, rootPaneCheckingEnabled);
        createB.setVisible(true);
    }//GEN-LAST:event_btThemHD5ActionPerformed

    private void btTimHD5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimHD5ActionPerformed
        
        author_list = (ArrayList<Author>) authorController.readDataFromFile("authors.txt");
        
        String searchKey = txtSearchAuthor.getText();
        
        author_list = authorController.searchAuthor(author_list, searchKey);
        if (author_list == null) {
            author_list = new ArrayList<>();
        }
        this.showData(author_list, tblModelAuthor);
    }//GEN-LAST:event_btTimHD5ActionPerformed

    private void tblSachMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSachMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tblSachMouseClicked

    private void btnReset4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset4ActionPerformed
        tblModelSach = (DefaultTableModel) tblSach.getModel();
        this.bookController = new BookController();
        showBookList();
    }//GEN-LAST:event_btnReset4ActionPerformed

    private void btXoaHD4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaHD4ActionPerformed
        //        Lấy ra chỉ số dòng chọn của người dùng click vào
        dongChon = tblSach.getSelectedRow();
        /*       Nếu danh sách rỗng hoặc người dùng chưa chọn dòng  thì in ra thông báo
        còn nếu không thì show ra màn hình xác nhận xóa */
        if (dongChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn một dòng cần xóa!");
        } else if (book_list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin để xóa!");
        } else {
            int confirm = JOptionPane.showConfirmDialog(
                rootPane,
                "Bạn có chắc chắn muốn xóa?",
                "Xác nhận xóa",
                JOptionPane.YES_NO_OPTION
            );
            /*           Người dùng chọn Yes sẽ tiến hành xóa thông tin khỏi danh sách và
            show lại danh sách sau khi xóa */
            if (confirm == JOptionPane.YES_OPTION) {
                book_list.remove(dongChon);
                bookController.writeToFile(book_list, "books.txt");
                this.showData(book_list, tblModelSach);
            }
        }
    }//GEN-LAST:event_btXoaHD4ActionPerformed

    private void btSuaHD4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaHD4ActionPerformed
        //        Lấy ra chỉ số dòng chọn của người dùng click vào
        dongChon = tblSach.getSelectedRow();
        /*       Nếu danh sách rỗng hoặc người dùng chưa chọn dòng  thì in ra thông báo
        còn nếu không thì gọi đến màn hình sửa */
        if (book_list.isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Không có thông tin xe để sửa!");
        } else if (dongChon == -1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy chọn dòng chứa thông tin cần sửa!");
        } else {
            EditBook sua = new EditBook(this, rootPaneCheckingEnabled);
            sua.setEditData(book_list.get(dongChon));
            sua.setVisible(true);
        }

    }//GEN-LAST:event_btSuaHD4ActionPerformed

    private void btThemHD4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemHD4ActionPerformed
        CreateBook createB = new CreateBook(this, rootPaneCheckingEnabled);
        createB.setVisible(true);
    }//GEN-LAST:event_btThemHD4ActionPerformed

    private void btTimHD4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTimHD4ActionPerformed
        book_list = (ArrayList<Book>) bookController.readDataFromFile("books.txt");
        
        String searchValue = txtSearch4.getText();
        
        book_list = bookController.searchBook(book_list, searchValue);
        System.out.println(book_list.size());
        if (book_list == null) {
            book_list = new ArrayList<>();
        }
        this.showData(book_list, tblModelSach);
    }//GEN-LAST:event_btTimHD4ActionPerformed

    private void btXoaHD3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaHD3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btXoaHD3ActionPerformed

    private void comboSapXepBookActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSapXepBookActionPerformed
        //        Lấy ra chỉ số của JcomboBox
        int index = comboSapXepBook.getSelectedIndex();
        //        Nếu chỉ số là 0 thì sắp theo thành tiền còn chỉ số là 1 thì sắp theo ngày sửa
        if (index == 0) {
            bookController.sortByPrice(book_list);
        } else if (index == 1) {
            bookController.sortByPrice2(book_list);
        }
        this.showData(book_list, tblModelSach);
    }//GEN-LAST:event_comboSapXepBookActionPerformed

    private void comboSapXepBookPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboSapXepBookPropertyChange
        //        Lấy ra chỉ số của JcomboBox
        
    }//GEN-LAST:event_comboSapXepBookPropertyChange

    private void comboSapXepAuthorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSapXepAuthorActionPerformed
        int index = comboSapXepAuthor.getSelectedIndex();
        System.out.println(index);
        if (index == 0) {
            authorController.sortByName(author_list);
        } else if (index == 1) {
            authorController.sortByName2(author_list);
        }
        this.showData(author_list, tblModelAuthor);
    }//GEN-LAST:event_comboSapXepAuthorActionPerformed

    private void comboSapXepAuthorPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboSapXepAuthorPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSapXepAuthorPropertyChange

    private void comboSapXepAuthorVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_comboSapXepAuthorVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSapXepAuthorVetoableChange

    private void comboSapXepCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSapXepCategoryActionPerformed
        int index = comboSapXepCategory.getSelectedIndex();
        if (index == 0) {
            categoryController.sortByName(category_list);
        } else if (index == 1) {
            categoryController.sortByName2(category_list);
        }
        this.showData(category_list, tblModelCategory);        // TODO add your handling code here:
    }//GEN-LAST:event_comboSapXepCategoryActionPerformed

    private void comboSapXepCategoryPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboSapXepCategoryPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSapXepCategoryPropertyChange

    private void comboSapXepCategoryVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_comboSapXepCategoryVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSapXepCategoryVetoableChange

    private void txtSearchSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSearchSupplierActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchSupplierActionPerformed

    private void comboSapXepSupplierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboSapXepSupplierActionPerformed
        int index = comboSapXepSupplier.getSelectedIndex();
        if (index == 0) {
            supplierController.sortByName(supplier_list);
        } else if (index == 1) {
            supplierController.sortByName2(supplier_list);
        }
        this.showData(supplier_list, tblModelSupplier);    
    }//GEN-LAST:event_comboSapXepSupplierActionPerformed

    private void comboSapXepSupplierPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboSapXepSupplierPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSapXepSupplierPropertyChange

    private void comboSapXepSupplierVetoableChange(java.beans.PropertyChangeEvent evt)throws java.beans.PropertyVetoException {//GEN-FIRST:event_comboSapXepSupplierVetoableChange
        // TODO add your handling code here:
    }//GEN-LAST:event_comboSapXepSupplierVetoableChange
    private void showBookList() {
        book_list = (ArrayList<Book>) bookController.readDataFromFile("books.txt");
        if (book_list == null) {
            book_list = new ArrayList<>();
        }
        this.showData(book_list, tblModelSach);
    }
    
    private void showAuthorList() {
        author_list = (ArrayList<Author>) authorController.readDataFromFile("authors.txt");
        if (author_list == null) {
            author_list = new ArrayList<>();
        }
        this.showData(author_list, tblModelAuthor);
    }
    
    private void showCategoryList() {
        category_list = (ArrayList<Category>) categoryController.readDataFromFile("categories.txt");
        if (category_list == null) {
            category_list = new ArrayList<>();
        }
        this.showData(category_list, tblModelCategory);
    }
    
    private void showBranchList() {
        branch_list = (ArrayList<Branch>) branchController.readDataFromFile("branches.txt");
        if (branch_list == null) {
            branch_list = new ArrayList<>();
        }
        this.showData(branch_list, tblModelBranch);
    }
    
    private void showCustomerList() {
        customer_list = (ArrayList<Customer>) customerController.readDataFromFile("customers.txt");
        if (customer_list == null) {
            customer_list = new ArrayList<>();
        }
        this.showData(customer_list, tblModelCustomer);
    }
    
    private void showEmployeeList() {
        employee_list = (ArrayList<Employee>) employeeController.readDataFromFile("employees.txt");
        if (employee_list == null) {
            employee_list = new ArrayList<>();
        }
        this.showData(employee_list, tblModelEmployee);
    }
    
    private void showOrderList() {
        order_list = (ArrayList<Order>) orderController.readDataFromFile("orders.txt");
        if (order_list == null) {
            order_list = new ArrayList<>();
        }
        this.showData(order_list, tblModelOrder);
    }
    
    private void showPublisherList() {
        publisher_list = (ArrayList<Publisher>) publisherController.readDataFromFile("publishers.txt");
        if (publisher_list == null) {
            publisher_list = new ArrayList<>();
        }
        this.showData(publisher_list, tblModelPublisher);
    }
    
    private void showReceiptList() {
        receipt_list = (ArrayList<Receipt>) receiptController.readDataFromFile("receipts.txt");
        if (receipt_list == null) {
            receipt_list = new ArrayList<>();
        }
        this.showData(receipt_list, tblModelReceipt);
    }
    
    private void showSupplierList() {
        supplier_list = (ArrayList<Supplier>) supplierController.readDataFromFile("suppliers.txt");
        if (supplier_list == null) {
            supplier_list = new ArrayList<>();
        }
        this.showData(supplier_list, tblModelSupplier);
    }
    
    public void handleCreateBook(Book x) {
        book_list.add(x);
        this.showData(book_list, tblModelSach);
        bookController.writeToFile(book_list, "books.txt");  
    }
    
    public void handleCreateAuthor(Author x) {
        author_list.add(x);
        this.showData(author_list, tblModelAuthor);
        authorController.writeToFile(author_list, "authors.txt");  
    }
    
    public void handleCreateCategory(Category x) {
        category_list.add(x);
        this.showData(category_list, tblModelCategory);
        categoryController.writeToFile(category_list, "categories.txt");  
    }
    
    public void handleCreateBranch(Branch x) {
        branch_list.add(x);
        this.showData(branch_list, tblModelBranch);
        branchController.writeToFile(branch_list, "branches.txt");  
    }
    
    public void handleCreateCustomer(Customer x) {
        customer_list.add(x);
        this.showData(customer_list, tblModelCustomer);
        customerController.writeToFile(customer_list, "customers.txt");  
    }
    
    public void handleCreateEmployee(Employee x) {
        employee_list.add(x);
        this.showData(employee_list, tblModelEmployee);
        employeeController.writeToFile(employee_list, "employees.txt");  
    }
    
    public void handleCreateOrder(Order x) {
        order_list.add(x);
        this.showData(order_list, tblModelOrder);
        orderController.writeToFile(order_list, "orders.txt");  
    }
    
    public void handleCreateOrderDetail(models.OrderDetail x) {
        order_detail_list.add(x);
        orderDetailController.writeToFile(order_detail_list, "order_details.txt");  
    }
    
    public void handleCreatePublisher(Publisher x) {
        publisher_list.add(x);
        this.showData(publisher_list, tblModelPublisher);
        publisherController.writeToFile(publisher_list, "publishers.txt");  
    }
    
    public void handleCreateReceipt(Receipt x) {
        receipt_list.add(x);
        this.showData(receipt_list, tblModelReceipt);
        receiptController.writeToFile(receipt_list, "receipts.txt");  
    }
    
    public void handleCreateSupplier(Supplier x) {
        supplier_list.add(x);
        this.showData(supplier_list, tblModelSupplier);
        supplierController.writeToFile(supplier_list, "suppliers.txt");  
    }
    
    public void updateBook(Book x) {
        int oldIndex = dongChon;
        book_list.remove(oldIndex);
        book_list.add(oldIndex, x);
        showData(book_list, tblModelSach);
        bookController.writeToFile(book_list, "books.txt");
    }
    
    public void updateSupplier(Supplier x) {
        int oldIndex = dongChon;
        supplier_list.remove(oldIndex);
        supplier_list.add(oldIndex, x);
        showData(supplier_list, tblModelSupplier);
        supplierController.writeToFile(supplier_list, "suppliers.txt");
    }
    
    public void updateAuthor(Author x) {
        int oldIndex = dongChon;
        author_list.remove(oldIndex);
        author_list.add(oldIndex, x);
        showData(author_list, tblModelAuthor);
        authorController.writeToFile(author_list, "authors.txt");
    }
    
    public void updateBranch(Branch x) {
        int oldIndex = dongChon;
        branch_list.remove(oldIndex);
        branch_list.add(oldIndex, x);
        showData(branch_list, tblModelBranch);
        branchController.writeToFile(branch_list, "branches.txt");
    }
    
    public void updateCategory(Category x) {
        int oldIndex = dongChon;
        category_list.remove(oldIndex);
        category_list.add(oldIndex, x);
        showData(category_list, tblModelCategory);
        categoryController.writeToFile(category_list, "categories.txt");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    HomePage h = new HomePage();
                    h.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    h.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panle_timKiem;
    private javax.swing.JPanel Panle_timKiem1;
    private javax.swing.JPanel Panle_timKiem2;
    private javax.swing.JPanel Panle_timKiem3;
    private javax.swing.JPanel Panle_timKiem4;
    private javax.swing.JPanel Panle_timKiem5;
    private javax.swing.JPanel Panle_timKiem6;
    private javax.swing.JRadioButton RadioSearchByKH2;
    private javax.swing.JRadioButton RadioSearchByMaHD2;
    private javax.swing.JRadioButton RadioSortByTime2;
    private javax.swing.JRadioButton RadioSortTT2;
    private javax.swing.JButton btSuaHD;
    private javax.swing.JButton btSuaHD1;
    private javax.swing.JButton btSuaHD4;
    private javax.swing.JButton btSuaHD5;
    private javax.swing.JButton btSuaHD6;
    private javax.swing.JButton btThemHD;
    private javax.swing.JButton btThemHD1;
    private javax.swing.JButton btThemHD2;
    private javax.swing.JButton btThemHD3;
    private javax.swing.JButton btThemHD4;
    private javax.swing.JButton btThemHD5;
    private javax.swing.JButton btThemHD6;
    private javax.swing.JButton btTimHD;
    private javax.swing.JButton btTimHD1;
    private javax.swing.JButton btTimHD2;
    private javax.swing.JButton btTimHD3;
    private javax.swing.JButton btTimHD4;
    private javax.swing.JButton btTimHD5;
    private javax.swing.JButton btTimHD6;
    private javax.swing.JButton btXemChiTietHD2;
    private javax.swing.JButton btXoaHD;
    private javax.swing.JButton btXoaHD1;
    private javax.swing.JButton btXoaHD2;
    private javax.swing.JButton btXoaHD3;
    private javax.swing.JButton btXoaHD4;
    private javax.swing.JButton btXoaHD5;
    private javax.swing.JButton btXoaHD6;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnReset1;
    private javax.swing.JButton btnReset2;
    private javax.swing.JButton btnReset3;
    private javax.swing.JButton btnReset4;
    private javax.swing.JButton btnReset5;
    private javax.swing.JButton btnReset6;
    private javax.swing.JComboBox<String> comboSapXepAuthor;
    private javax.swing.JComboBox<String> comboSapXepBook;
    private javax.swing.JComboBox<String> comboSapXepCategory;
    private javax.swing.JComboBox<String> comboSapXepSupplier;
    private javax.swing.JPanel iPanel10;
    private javax.swing.JPanel iPanel11;
    private javax.swing.JPanel iPanel9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JButton jbtXep2;
    private javax.swing.JTable tblAuthor;
    private javax.swing.JTable tblBranch;
    private javax.swing.JTable tblCategory;
    private javax.swing.JTable tblOrder;
    private javax.swing.JTable tblReceipt;
    private javax.swing.JTable tblSach;
    private javax.swing.JTable tblSupplier;
    private javax.swing.JTextField txtSearch2;
    private javax.swing.JTextField txtSearch3;
    private javax.swing.JTextField txtSearch4;
    private javax.swing.JTextField txtSearchAuthor;
    private javax.swing.JTextField txtSearchBranch;
    private javax.swing.JTextField txtSearchCategory;
    private javax.swing.JTextField txtSearchSupplier;
    // End of variables declaration//GEN-END:variables
}
