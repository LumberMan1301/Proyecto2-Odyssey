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
    public partial class Odyssey : Form
    {
        public Odyssey()
        {
            InitializeComponent();
        }

        private void listBox1_SelectedIndexChanged(object sender, EventArgs e)
        {

        }

        private void button1_Click(object sender, EventArgs e)
        {

            // connect to server
            TcpClient client = new TcpClient("192.168.100.15", 1133);

            //...

            String name = "Cargando Canciones";

            // send name to server
            byte[] buf;
            // append newline as server expects a line to be read
            buf = Encoding.UTF8.GetBytes(name + "\n");

            NetworkStream stream = client.GetStream();
            stream.Write(buf, 0, name.Length + 1);
        }

        private void label1_Click(object sender, EventArgs e)
        {

        }

        private void Odyssey_Load(object sender, EventArgs e)
        {

        }

        private void button2_Click(object sender, EventArgs e)
        {

        }
    }
}
