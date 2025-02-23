// Vedin-info

#include <iostream>
#include <string>
#include <fstream>
using namespace std;

int main()
{
    string caminho1 = "app/Vedin";
    string caminho2 = "app.Vedin";

    string init1 = "javac " + caminho1 + ".java";
    string init2 = "start /B javaw " + caminho2;
    ifstream Vedin(caminho1 + ".java");

    if (Vedin.is_open())
    {
        cout << "Carregando..." << endl;
        system(init1.c_str());
        cout << "Iniciando..." << endl;
        system(init2.c_str());
        cout << "Sucesso!" << endl;
    }
    else
    {
        cout << "Arquivo inexistente!" << endl;
    }
}