using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;
using System.Net;
using System.Net.Sockets;

namespace WindowsFormsApp1
{
    public partial class Registro : Form
    {
        public Registro()
        {
            InitializeComponent();
        }

        private void pictureBox1_Click(object sender, EventArgs e)
        {

        }

        private void Form1_Load(object sender, EventArgs e)
        {

        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {
            Login abrir = new Login();
            abrir.Show();
            this.Hide();
        }

        private void pictureBox1_Click_1(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {

            // connect to server
            TcpClient client = new TcpClient("192.168.100.7", 1133);

            
            String name = textBox1.Text;

            // send name to server
            byte[] buf;
            // append newline as server expects a line to be read
            buf = Encoding.UTF8.GetBytes(name + "\n");

            NetworkStream stream = client.GetStream();
            stream.Write(buf, 0, name.Length + 1);
            
            Odyssey abrir = new Odyssey();
            abrir.Show();
            this.Hide();

        }
    }
}
