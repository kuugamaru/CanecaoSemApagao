CREATE TABLE IF NOT EXISTS usuarios (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    email TEXT UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS gestores (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    nome TEXT NOT NULL,
    setorResponsavel TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS ocorrencias (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    descricao TEXT NOT NULL,
    categoria TEXT NOT NULL,
    endereco TEXT NOT NULL,
    status TEXT NOT NULL DEFAULT 'aberta',
    usuario_id INTEGER,
    gestor_id INTEGER,
    FOREIGN KEY (usuario_id) REFERENCES usuarios(id) ON DELETE SET NULL,
    FOREIGN KEY (gestor_id) REFERENCES gestores(id) ON DELETE SET NULL
);