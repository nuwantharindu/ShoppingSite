const { Sequelize, DataTypes } = require('sequelize');

const sequelize = new Sequelize
('database', 'username', 'password', {
  host: 'localhost',
  dialect: 'mysql',
});

const User = sequelize.define('User', {
  email: {
    type: DataTypes.STRING,
    allowNull: false,
    unique: true,
  },
  password: {
    type: DataTypes.STRING,
    allowNull: false,
  },
  role: {
    type: DataTypes.ENUM('BUYER', 'SELLER'),
    allowNull: false,
  },
}, { timestamps: true });

sequelize.sync()
  .then(() => {
    console.log("User table created");
  })
  .catch((err) => {
    console.error("Error creating user table:", err);
  });

module.exports = User;
