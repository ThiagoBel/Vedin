// vedin-info

package app;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Vedin {
    private boolean definirTop = false;
    private boolean definirFundo = false;
    private String estado = "Deixar no topo";
    private String statuse = "Normal";
    private String modo = "Modo claro";
    private double versao = 0.1;
    private String alert = "sound/alert.wav";
    private String click = "sound/click.wav";
    private String sucess = "sound/sucess.wav";
    private int palavras;
    private int width = 400;
    private int heigth = 600;

    private void playSound(String soundFile) {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(soundFile));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private final String[] palavrasProibidas = {
            "virus", "malware", "trojan", "kill", "system", "system32", "explode", "spy", "spyware",
            "hack", "hacker", "taskkill", "remove", "os", "destroy", "attack", "porn", "spam",
            "blacklist", "atack", "delet", "delete", "create", "adware", "worm", "free",
            "ransomware", "keylogger", "botnet", "phishing", "exploit", "rootkit", "backdoor",
            "payload", "scareware", "cryptojacking", "denial of service", "zero-day exploit",
            "shellcode", "sql injection", "malvertising", "credential stuffing", "fishing",
            "social engineering", "drive-by download", "insider threat", "payload delivery",
            "network sniffing", "man-in-the-middle", "fileless malware", "remote access trojan",
            "DNS spoofing", "code injection", "browser hijacker", "system exploit", "data breach",
            "vulnerability", "malicious script", "APT", "Advanced Persistent Threat", "worm propagation",
            "ransom note", "malicious link", "payload execution", "exploit kit", "binary malware",
            "attack vector", "vulnerability scanner", "network intrusion", "data exfiltration",
            "script kiddie", "targeted attack", "emerging threat", "command and control (C2)",
            "bot herder", "identity theft", "spyware variant", "rogue software", "internet worm",
            "polymorphic virus", "trojan horse", "infectar", "criptografar", "roubar", "monitorar",
            "exfiltrar", "instalar", "destruir", "replicar", "disfarçar", "analisar", "enganar",
            "ativar", "desativar", "descarregar", "reiniciar", "comprometer", "falsificar",
            "desencadear", "distribuir", "desinstalar", "infect", "encrypt", "steal", "monitor",
            "exfiltrate", "install", "destroy", "replicate", "disguise", "analyze", "deceive",
            "activate", "deactivate", "download", "restart", "compromise", "forge", "trigger",
            "distribute", "uninstall", "cry", "scan", "execute", "override", "bypass", "corrupt",
            "harvest", "phish", "transfer", "disable", "patch", "provision", "target", "track",
            "intercept", "disrupt", "contain", "subvert", "modify", "reinforce", "scam", "pay",
            "rastrear", "explodir", "guardar", "iniciar", "reset", "rd", "copy", "crypto",
            "format", "formata", "inutilizar", "false", "exec", "eval", "subprocess", "popen",
            "cmd.exe", "/bin/bash", "PowerShell", "base64_decode", "rot13", "str_rot13",
            "gzinflate", "gzdecode", "unserialize", "decode", "wget", "curl", "ftp", "sftp",
            "http.get", "socket", "connect", "bind", "chmod", "chown", "unlink", "rm -rf",
            "fopen", "read", "write", "loop", "goto loop", ":loop", "rc", "http:", "dir",
            "tree", "deceptive", "unauthorized access", "threat", "trojanized", "malcontent",
            "infiltrate", "counterfeit", "snoop", "intrusion", "secret", "ip", "rule34",
            "ddos", "cheat", "xit", "deepweb", "darkweb", "gore", "lag", "wannacry", "for",
            "while", "while(", "invisible", "visible", "stall", "Antivirus", "Firewall", "Update",
            "Whitelist", "Patch", "Secure", "Backup", "Protect", "Authenticate", "Audit", "Integrity",
            "Compliance", "Credential", "Authorization", "Isolation", "Encryption", "Monitoring",
            "Forensics", "Sanitize", "Safeguard", "Incident", "Policy", "Risk", "Mitigation",
            "Assessment", "Audit Trail", "Incident Response", "Breach", "Encryption Key", "SMS Malware",
            "IoT Malware", "Cryptojacker"

    };
    private final String[] palavrasComandas = {
            "vedin-info", "vedin-system"
    };

    public Vedin() {
        palavras = palavrasProibidas.length;

        JFrame frame = new JFrame("Vedin");
        JButton init = new JButton("Iniciar");
        JButton top = new JButton(estado);
        JButton fundo = new JButton(modo);
        JButton vers = new JButton("Versão");
        JButton aviso = new JButton("Ver aviso");
        JButton guide = new JButton("Guia");
        JButton pv = new JButton("Palavras");
        JLabel status = new JLabel(statuse);
        JLabel c = new JLabel("© 2025 Thiago Bel - Vedin");
        ImageIcon logo = new ImageIcon("images/logo.png");

        Image imagemRedimensionada = logo.getImage().getScaledInstance(300, 300, Image.SCALE_SMOOTH);
        ImageIcon imagemIconRedimensionada = new ImageIcon(imagemRedimensionada);

        JLabel imagem = new JLabel(imagemIconRedimensionada);
        JOptionPane.showMessageDialog(frame,
                "AVISO IMPORTANTE!!!\nO APLICATIVO NÃO É UM ANTI VIRUS, É UM DETECTOR DE PALAVRAS COM POSSÍVEIS CHANCES DE TER VÍRUS,\nCASO DETECTAR UM ARQUIVO LIMPO, TOME CUIDADO, POIS EU >APENAS< DETECTO PALAVRAS!\n\nAVISO IMPORTANTE 2!!!\nEU NÃO CONSIGO LER ARQUIVOS .EXE, .OBJ, ETC,\nEU APENAS CONSIGO LER ARQUIVOS DE TEXTOS COMO\nPOR EXEMPLO: .CPP, .JAVA, .PY, ETC. NÃO COLOQUE ARQUIVOS .EXE!",
                "Vedin", JOptionPane.WARNING_MESSAGE);
        playSound("sound/click.wav");

        frame.setSize(width, heigth);
        frame.setMinimumSize(new Dimension(width, heigth));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setIconImage(logo.getImage());
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setAlwaysOnTop(false);

        imagem.setBounds(50, 10, 300, 200);
        frame.add(imagem);

        init.setBounds(50, 220, 300, 30);
        frame.add(init);

        top.setBounds(50, 250, 300, 30);
        frame.add(top);

        fundo.setBounds(50, 280, 300, 30);
        frame.add(fundo);

        vers.setBounds(50, 310, 300, 30);
        frame.add(vers);

        aviso.setBounds(50, 340, 300, 30);
        frame.add(aviso);

        guide.setBounds(50, 370, 300, 30);
        frame.add(guide);

        pv.setBounds(50, 400, 300, 30);
        frame.add(pv);

        status.setBounds(50, 430, 300, 30);
        frame.add(status);

        c.setBounds(120, 500, 300, 30);
        frame.add(c);

        top.addActionListener(_ -> {
            playSound(click);
            definirTop = !definirTop;
            frame.setAlwaysOnTop(definirTop);
            estado = definirTop ? "Deixar normal" : "Deixar no topo";
            statuse = definirTop ? "Topo" : "Normal";
            top.setText(estado);
            status.setText(statuse);
        });

        fundo.addActionListener(_ -> {
            playSound(click);
            definirFundo = !definirFundo;
            Color backgroundColor = definirFundo ? new Color(45, 45, 45) : Color.WHITE;
            Color textColor = definirFundo ? Color.WHITE : Color.BLACK;

            frame.getContentPane().setBackground(backgroundColor);

            status.setForeground(textColor);
            c.setForeground(textColor);

            modo = definirFundo ? "Modo escuro" : "Modo claro";
            fundo.setText(modo);
        });

        vers.addActionListener(_ -> {
            playSound(click);
            JOptionPane.showMessageDialog(frame, "Versão: " + versao, "Vedin", JOptionPane.INFORMATION_MESSAGE);
            playSound(click);
        });

        aviso.addActionListener(_ -> {
            playSound(click);
            JOptionPane.showMessageDialog(frame,
                    "AVISO IMPORTANTE!!!\nO APLICATIVO NÃO É UM ANTI VIRUS, É UM DETECTOR DE PALAVRAS COM POSSÍVEIS CHANCES DE TER VÍRUS,\nCASO DETECTAR UM ARQUIVO LIMPO, TOME CUIDADO, POIS EU >APENAS< DETECTO PALAVRAS!\n\nAVISO IMPORTANTE 2!!!\nEU NÃO CONSIGO LER ARQUIVOS .EXE, .OBJ, ETC,\nEU APENAS CONSIGO LER ARQUIVOS DE TEXTOS COMO\nPOR EXEMPLO: .CPP, .JAVA, .PY, ETC. NÃO COLOQUE ARQUIVOS .EXE!",
                    "Vedin", JOptionPane.WARNING_MESSAGE);
            playSound(click);
        });

        guide.addActionListener(_ -> {
            playSound(click);
            JOptionPane.showMessageDialog(frame,
                    "Guia do Vedin\n\nComo usar?\nCique no botão \"iniciar\" e escolha o arquivo.\n\nO que é o Vedin?\nVedin é um aplicativo que verifica se o arquivo selecionado tem palavras que podem ser um problema, exemplo: virus, malware, rc, rd...\n\nQuais arquivos o Vedin verifica?\nO Vedin consegue ver os arquivos: .cpp, .cxx, .c++, .c, .java, .py, .html, .htm, .js, .bat, .bash, .vbs, .vb, etc...\n\nQuais arquivos o Vedin NÃO verifica?\nO Vedin não consegue ver os arquivos: .jar, .exe, .png, etc...\n\nPara que serve a opção \"Palavras\"?\nA opção Palavras mostra quantas Palavras tem no sistema Vedin.",
                    "Vedin", JOptionPane.INFORMATION_MESSAGE);
            playSound(click);
        });

        pv.addActionListener(_ -> {
            playSound(click);
            JOptionPane.showMessageDialog(frame, palavras + " Palavras", "Vedin", JOptionPane.INFORMATION_MESSAGE);
            playSound(click);
        });

        init.addActionListener(_ -> {
            playSound(click);
            iniciarPrograma(frame);
            playSound(click);
        });

        frame.setVisible(true);
    }

    private void iniciarPrograma(JFrame frame) {
        JFileChooser fileChooser = new JFileChooser();

        fileChooser.setFileFilter(new javax.swing.filechooser.FileFilter() {
            @Override
            public boolean accept(File f) {
                return f.isDirectory() ||
                        f.getName().toLowerCase().endsWith(".cpp") ||
                        f.getName().toLowerCase().endsWith(".py") ||
                        f.getName().toLowerCase().endsWith(".vbs") ||
                        f.getName().toLowerCase().endsWith(".bat") ||
                        f.getName().toLowerCase().endsWith(".cmd") ||
                        f.getName().toLowerCase().endsWith(".bash") ||
                        f.getName().toLowerCase().endsWith(".cxx") ||
                        f.getName().toLowerCase().endsWith(".csharp") ||
                        f.getName().toLowerCase().endsWith(".js") ||
                        f.getName().toLowerCase().endsWith(".vb") ||
                        f.getName().toLowerCase().endsWith(".c++") ||
                        f.getName().toLowerCase().endsWith(".java") ||
                        f.getName().toLowerCase().endsWith(".c") ||
                        f.getName().toLowerCase().endsWith(".txt") ||
                        f.getName().toLowerCase().endsWith(".md") ||
                        f.getName().toLowerCase().endsWith(".csv") ||
                        f.getName().toLowerCase().endsWith(".json") ||
                        f.getName().toLowerCase().endsWith(".xml") ||
                        f.getName().toLowerCase().endsWith(".html") ||
                        f.getName().toLowerCase().endsWith(".css") ||
                        f.getName().toLowerCase().endsWith(".sql") ||
                        f.getName().toLowerCase().endsWith(".sh") ||
                        f.getName().toLowerCase().endsWith(".pl") ||
                        f.getName().toLowerCase().endsWith(".rb") ||
                        f.getName().toLowerCase().endsWith(".go") ||
                        f.getName().toLowerCase().endsWith(".dart") ||
                        f.getName().toLowerCase().endsWith(".r") ||
                        f.getName().toLowerCase().endsWith(".php") ||
                        f.getName().toLowerCase().endsWith(".lua") ||
                        f.getName().toLowerCase().endsWith(".f90") ||
                        f.getName().toLowerCase().endsWith(".for") ||
                        f.getName().toLowerCase().endsWith(".scala") ||
                        f.getName().toLowerCase().endsWith(".pas") ||
                        f.getName().toLowerCase().endsWith(".asm");
            }

            @Override
            public String getDescription() {
                return ".cpp, .py, .vbs, .bat, .cmd, .bash, ...";
            }
        });

        int retorno = fileChooser.showOpenDialog(frame);

        if (retorno == JFileChooser.APPROVE_OPTION) {
            File arquivo = fileChooser.getSelectedFile();
            new Thread(() -> verificarArquivo(arquivo)).start();
        }
    }

    private void verificarArquivo(File arquivo) {
        JFrame loadingFrame = new JFrame("Verificando...");
        loadingFrame.setSize(300, 100);
        loadingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        loadingFrame.setLayout(new FlowLayout());
        JLabel loadingLabel = new JLabel("Verificando arquivo...");
        JProgressBar progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        loadingFrame.add(loadingLabel);
        loadingFrame.add(progressBar);
        loadingFrame.setLocationRelativeTo(null);
        loadingFrame.setAlwaysOnTop(true);
        loadingFrame.setVisible(true);

        SwingUtilities.invokeLater(() -> {
            try {
                Thread.sleep(500);

                java.util.Map<String, Integer> contagemPalavras = new java.util.HashMap<>();
                boolean encontrado = false;
                boolean comandoEncontrado = false;
                int totalPalavrasProibidas = 0;

                try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
                    String linha;
                    while ((linha = br.readLine()) != null) {
                        String[] palavrasLinha = linha.toLowerCase().split("\\W+");

                        for (String palavra : palavrasLinha) {
                            if (java.util.Arrays.asList(palavrasProibidas).contains(palavra)) {
                                contagemPalavras.put(palavra, contagemPalavras.getOrDefault(palavra, 0) + 1);
                                totalPalavrasProibidas++;
                                encontrado = true;
                            }
                        }

                        for (String palavraComando : palavrasComandas) {
                            if (linha.toLowerCase().contains(palavraComando.toLowerCase())) {
                                comandoEncontrado = true;
                            }
                        }
                    }
                }

                loadingFrame.dispose();

                if (comandoEncontrado) {
                    JOptionPane optionPane = new JOptionPane(
                            "Este é um arquivo do Vedin! (Tome cuidado do mesmo jeito...)",
                            JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Informação");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }

                if (encontrado) {
                    playSound(alert);
                    StringBuilder mensagem = new StringBuilder("Palavras suspeitas encontradas:\n\n");
                    int contador = 0;
                    for (String palavra : contagemPalavras.keySet()) {
                        int contagem = contagemPalavras.get(palavra);
                        mensagem.append(palavra).append("/").append(contagem).append("x, ");
                        contador++;
                        if (contador % 6 == 0) {
                            mensagem.append("\n");
                        }
                    }
                    mensagem.append("\n\nTotal de palavras suspeitas encontradas: ").append(totalPalavrasProibidas);

                    JOptionPane optionPane = new JOptionPane(mensagem.toString(), JOptionPane.WARNING_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Resultado");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                } else {
                    playSound(sucess);
                    JOptionPane optionPane = new JOptionPane("Nenhuma palavra suspeita encontrada.",
                            JOptionPane.INFORMATION_MESSAGE);
                    JDialog dialog = optionPane.createDialog("Resultado");
                    dialog.setAlwaysOnTop(true);
                    dialog.setVisible(true);
                }

                playSound(click);
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        });
    }

    public static void main(String[] args) {
        new Vedin();
    }
}